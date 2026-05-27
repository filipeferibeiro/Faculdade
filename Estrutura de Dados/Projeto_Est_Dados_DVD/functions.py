class BST:
    def __init__(self):
        self.root = None
        self.total_nodes = 0

    def insert(self, code, name, gender, state, value, root=-1):
        if root == -1:
            self.total_nodes += 1
            self.root = self.insert(code, name, gender, state, value, self.root)
            return
        else:
            if root == None:
                root = TreeNode(code, name, gender, state, value)
            elif code > root.code:
                root.right = self.insert(code, name, gender, state, value, root.right)
            elif code < root.code:
                root.left = self.insert(code, name, gender, state, value, root.left)
            return root

    def get_from_file(self):
        vetor = []
        file = open('locadora.txt', 'r')
        values = []
        for i in file:
            if i[0] == '-':
                vetor.append(values)
                values = []
            if i[0:15] == 'Código do DVD: ':
                values.append(int(i[15:len(i) -1]))
            if i[0:15] == 'Nome do filme: ':
                values.append(i[15:len(i) - 1])
            if i[0:8] == 'Gênero: ':
                values.append(i[8:len(i) - 1])
            if i[0:10] == 'Situação: ':
                values.append(i[10:len(i) - 1])
            if i[0:20] == 'Valor do aluguel: R$':
                values.append(float(i[20:len(i) - 1]))
        for i in range(len(vetor)):
            self.insert(vetor[i][0], vetor[i][1], vetor[i][2], vetor[i][3], vetor[i][4])

        file.close()

    def modify_file(self, root = -1):
        if (root == -1):
            root = self.root
            file = open('locadora.txt', 'w')
            file.write('')
            file.close()
        if (root != None):
            file = open('locadora.txt', 'a')
            file.write("Código do DVD: " + str(root.code))
            file.write("\nNome do filme: " + str(root.informations.name))
            file.write("\nGênero: " + str(root.informations.gender))
            file.write("\nSituação: " + str(root.informations.state))
            file.write("\nValor do aluguel: R$" + str(root.informations.value))
            file.write("\n-------------------------------\n")
            file.close()
            self.modify_file(root.left)
            self.modify_file(root.right)

    def get_total_nodes(self):
        return self.total_nodes

    def balanced(self, root = -1):
        if self.root is None:
            return None
        if root is -1:
            root = self.root
        ji = 0
        ji2 = 0
        if root.left is not None:
            ji = self.balanced(root.left)
        if root.right is not None:
            ji2 = self.balanced(root.right)
        if ji is not 0:
            return ji
        if ji2 is not 0:
            return ji2
        if root.left is None and root.right is None:
            return 0
        else:
            esq = self.height(root.left)
            dir = self.height(root.right)
            if (esq - dir) >= 2 or (dir - esq) >= 2:
                return root.code
            else:
                return 0

    def height(self, root=-1):
        if self.root is None:
            return
        if root is -1:
            root = self.root
        if root is None:
            return 0
        maioraltura = 0
        altura = 0
        if root.left is not None:
            altura = self.height(root.left)
        if altura > maioraltura:
            maioraltura = altura
        if root.right is not None:
            altura = self.height(root.right)
        if altura > maioraltura:
            maioraltura = altura

        return (maioraltura + 1)

    def search(self, type_search, data, root = -1):
        if type_search == 1: #Search by Code
            elements = self.get_informations(int(data))
            if elements != False:
                return (data, elements.name, elements.gender, elements.state, elements.value)
            else:
                return None
        elif type_search == 2: #Search by Name
            if self.root == None:
                return None
            if (root == -1):
                root = self.root
            elements = None
            dados = None
            if root.left is not None:
                elements = self.search(type_search, data, root.left)
            if dados is None:
                dados = elements
            if dados is not None:
                return dados
            if root.right is not None:
                elements = self.search(type_search, data, root.right)
            if root.informations.name == data:
                elements = root.informations
                return(root.code, elements.name, elements.gender, elements.state, elements.value)
            if dados is None:
                dados = elements
            if dados is not None:
                return dados
            return dados
        elif type_search == 3:  #Search by category
            if self.root == None:
                return None
            if root == -1:
                root = self.root
            verify = None
            if root.left is not None:
                verify = self.search(type_search, data, root.left)
            if root.right is not None:
                verify = self.search(type_search, data, root.right)
            if root.informations.gender == data:
                verify = 1
                print("\nCódigo do DVD:", root.code,
                      "\nNome do filme:", root.informations.name,
                      "\nGênero:", root.informations.gender,
                      "\nSituação:", root.informations.state,
                      "\nValor do aluguel: R$", root.informations.value,
                      "\n--------------------------------------------------------------------------------------")
                return verify
            return verify

    def give_back_movie(self, type_give_back_movie, data, root = -1):
        if type_give_back_movie == 1: #give_back_movie by Code
            elements = self.get_informations(int(data))
            if elements != False:
                if elements.state == 'alugado':
                    elements.state = 'disponível'
                    return True
                else:
                    return False
            else:
                return None
        elif type_give_back_movie == 2: #give_back_movie by Name
            if self.root == None:
                return None
            if (root == -1):
                root = self.root
            elements = None
            dados = None
            if root.left is not None:
                elements = self.give_back_movie(type_give_back_movie, data, root.left)
            if dados is None:
                dados = elements
            if dados is not None:
                return dados
            if root.right is not None:
                elements = self.give_back_movie(type_give_back_movie, data, root.right)
            if root.informations.name == data:
                elements = root.informations
                if elements.state == 'alugado':
                    elements.state = 'disponível'
                    return True
                else:
                    return False
            if dados is None:
                dados = elements
            if dados is not None:
                return dados
            return dados

    def rent(self, type_rent, data, root = -1):
        if type_rent == 1: #rent by Code
            elements = self.get_informations(int(data))
            if elements != False:
                if elements.state == 'disponível':
                    elements.state = 'alugado'
                    return True
                else:
                    return False
            else:
                return None
        elif type_rent == 2: #rent by Name
            if self.root == None:
                return None
            if (root == -1):
                root = self.root
            elements = None
            dados = None
            if root.left is not None:
                elements = self.rent(type_rent, data, root.left)
            if dados is None:
                dados = elements
            if dados is not None:
                return dados
            if root.right is not None:
                elements = self.rent(type_rent, data, root.right)
            if root.informations.name == data:
                elements = root.informations
                if elements.state == 'disponível':
                    elements.state = 'alugado'
                    return True
                else:
                    return False
            if dados is None:
                dados = elements
            if dados is not None:
                return dados
            return dados

    def get_informations(self, code):
        root = self.root
        while root != None and root.code != code:
            if code > root.code:
                root = root.right
            else:
                root = root.left
        if root == None:
            return False
        else:
            return root.informations

    def minValue(self, root=-1):
        if (root == -1):
            root = self.root

        if (root is None):
            return None

        while (root.left is not None):
            root = root.left

        return root

    def remove_node(self, code, informations = -1, root=-1):
        if (root == -1):
            self.total_nodes -= 1
            root = self.root
            if root != None:
                if (informations == -1):
                    informations = self.get_informations(code)
            self.root = self.remove_node(code, informations, self.root)
        else:
            if root == None:
                return root
            if code < root.code:
                root.left = self.remove_node(code, informations, root.left)
                return root
            if code > root.code:
                root.right = self.remove_node(code, informations, root.right)
                return root
            else:
                if root.left == None and root.right == None:
                    return None
                elif root.left == None or root.right == None:
                    if root.left != None:
                        return root.left
                    else:
                        return root.right
                else:
                    next = self.minValue(root.right)
                    tempCode = root.code
                    tempInformations = root.informations
                    root.code = next.code
                    root.informations = next.informations
                    next.code = tempCode
                    next.informations = tempInformations
                    root.right = self.remove_node(tempCode, tempInformations, root.right)
                    return root

    def inOrderTraversal(self, root=-1):
        if (root == -1):
            root = self.root

        if (root is not None):
            self.inOrderTraversal(root.left)
            print("Código do DVD:", root.code, "\nNome do filme:", root.informations.name, "\nGênero:", root.informations.gender, "\nSituação:", root.informations.state,
                  "\nValor do aluguel: R$", root.informations.value, "\n--------------------------------------------------------------------------------------")
            self.inOrderTraversal(root.right)

class TreeNode:
    def __init__(self, code, name, gender, state, value):
        self.code = code
        self.informations = NodeInformations(name, gender, state, value)
        self.left = None
        self.right = None

class NodeInformations:
    def __init__(self, name, gender, state, value):
        self.name = name
        self.gender = gender
        self.state = state
        self.value = value
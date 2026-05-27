package Pk_PDR;

public class ListaProjetos {
    public class NoProjetos {
        private Projeto no;
        private NoProjetos proximo = null;
        
        public NoProjetos(Projeto no) {
            this.no = no;
        }
        
        public Projeto getNo() {
            return no;
        }

        public NoProjetos getProximo() {
            return proximo;
        }

        public void setNo(Projeto no) {
            this.no = no;
        }

        public void setProximo(NoProjetos proximo) {
            this.proximo = proximo;
        }
    }
    
    private NoProjetos referencia = null;
    private int quant;
    
    public void addProjeto(Projeto proj) {
        NoProjetos newProj = new NoProjetos(proj);
        if (referencia == null) {
            referencia = newProj;
        }
        else {
            NoProjetos tempProj = referencia;
            while (tempProj.getProximo() != null) {
                tempProj = tempProj.getProximo();
            }
            tempProj.setProximo(newProj);   
        }
    }
    
    public void printProj() {
        int i = 0;
        NoProjetos tempProj = referencia;
        while (tempProj != null) {
            System.out.println(i + " - " + tempProj.getNo().getNome());
            tempProj = tempProj.getProximo();
        }
    }
    
    
}

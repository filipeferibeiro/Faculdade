package poo.exercicios;

public class Data {
    private int dia, mes, ano;

    Data (int dia, int mes, int ano) {
        this.dia  = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public boolean vemAntes (Data data) {
        if (this.ano < data.getAno()) {
            return true;
        }

        else if (this.ano > data.getAno()) {
            return false;
        }

        else if (this.ano == data.getAno() && this.mes < data.getMes()) {
            return true;
        }

        else if (this.ano == data.getAno() && this.mes > data.getMes()) {
            return false;
        }

        else if (this.ano == data.getAno() && this.mes == data.getMes() && this.dia < data.getDia()) {
            return true;
        }

        else if (this.ano == data.getAno() && this.mes == data.getMes() && this.dia > data.getDia()) {
            return true;
        }

        else {
            return true;
        }
    }
}

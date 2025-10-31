package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public void contratar(Desenvolvedor desenvolvedor) {

            if(desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);

        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedorWeb) {
        if(desenvolvedorWeb.isFullstack()) {
            desenvolvedores.add(desenvolvedorWeb);
        }
    }

    public Double getTotalSalarios() {
        Double total = 0.0;

        for(Desenvolvedor desenvolvedor : desenvolvedores) {
            total += desenvolvedor.calcularSalario();
        }

        return total;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer qtdDesenvolvedoresMobile = 0;

        for(Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor instanceof DesenvolvedorMobile) {
                qtdDesenvolvedoresMobile++;
            }
        }

        return qtdDesenvolvedoresMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> desenvolvedoresMaiorSalario = new ArrayList<>();

        for(Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor.calcularSalario() >= salario) {
                desenvolvedoresMaiorSalario.add(desenvolvedor);
            }
        }

        return desenvolvedoresMaiorSalario;
    }

    public Desenvolvedor buscarMenorSalario() {
        if(desenvolvedores.isEmpty()) {
            return null;
        }

        Desenvolvedor desenvolvedorMenorSalario = desenvolvedores.get(0);
        for(Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor.calcularSalario() < desenvolvedorMenorSalario.calcularSalario()) {
                desenvolvedorMenorSalario = desenvolvedor;
            }
        }

        return desenvolvedorMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresTecnologia = new ArrayList<>();
        for(Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor instanceof DesenvolvedorWeb web){
               if(tecnologia.equalsIgnoreCase(web.getBackend()) || tecnologia.equalsIgnoreCase(web.getFrontend()) || tecnologia.equalsIgnoreCase(web.getSgbd())){
                desenvolvedoresTecnologia.add(desenvolvedor);
                }
            } else if (desenvolvedor instanceof DesenvolvedorMobile mobile) {
                if (tecnologia.equalsIgnoreCase(mobile.getLinguagem())  || tecnologia.equalsIgnoreCase(mobile.getPlataforma()) ) {

                desenvolvedoresTecnologia.add(desenvolvedor);
                }
            }

        }
        return desenvolvedoresTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double somaSalarios=0.0;

        if(buscarPorTecnologia(tecnologia).isEmpty()) {
            return 0.0;
        }

        for(Desenvolvedor desenvolvedor : buscarPorTecnologia(tecnologia)) {
            somaSalarios += desenvolvedor.calcularSalario();
        }
        return somaSalarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}

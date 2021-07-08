package co.edu.utp.misiontic2022.c2;

public class Jugador {

    //1. Atributos
    private String nombre;
    private String sexo;
    private int pg;
    private int pp;
    private String olimpicos;
    private int rankingATP;
    private int doblesFaltas;
    private int torneosJugados;
    private int saquesPerfectos;
    private float probabilidad;
    
    //2. Constructores
    Jugador(String pNombre, String pSexo, int pPg, int pPp, String pOlimpicos,int pRankingATP, int pDoblesFaltas, int pTorneosJugados, int pSaquesPerfectos, float pProbabilidad){
        this.nombre = pNombre;
        this.sexo = pSexo;
        this.pg = pPg;
        this.pp = pPp;
        this.olimpicos = pOlimpicos;
        this.rankingATP = pRankingATP;
        this.doblesFaltas = pDoblesFaltas;
        this.torneosJugados = pTorneosJugados ;
        this.saquesPerfectos = pSaquesPerfectos;
        this.probabilidad = pProbabilidad;    
        
    }

    Jugador(String pNombre, String pSexo, int pPg, int pPp, String pOlimpicos,int pRankingATP, int pDoblesFaltas, int pTorneosJugados, int pSaquesPerfectos){
        this.nombre = pNombre;
        this.sexo = pSexo;
        this.pg = pPg;
        this.pp = pPp;
        this.olimpicos = pOlimpicos;
        this.rankingATP = pRankingATP;
        this.doblesFaltas = pDoblesFaltas;
        this.torneosJugados = pTorneosJugados ;
        this.saquesPerfectos = pSaquesPerfectos;
        this.probabilidad = 0;    
        
    }

    //3. Métodos Generales
    public void mostrarJugador(){
        
        System.out.println("Nombre: "+this.nombre);
        //System.out.println("Nombre: "+this.getNombre());
        System.out.println("Sexo: "+this.sexo);
        System.out.println("PG: "+this.pg);
        System.out.println("PP: "+this.pp);
        System.out.println("Olimpicos: "+this.olimpicos);
        System.out.println("Ranking ATP: "+this.rankingATP);
        System.out.println("Dobles Faltas: "+this.doblesFaltas);
        System.out.println("Torneos Jugados: "+this.torneosJugados);
        System.out.println("Saques Perfectos: "+this.saquesPerfectos);
        System.out.println("Probabilidad: "+this.probabilidad);
    }
    public void calcularProbabilidad(){
        System.out.println("******************Jugador antes *****************");
        this.mostrarJugador();
        if (this.sexo == "mujer"){
            if (this.pg > this.pp || this.rankingATP > 2400) {
                if (this.doblesFaltas <= 4 && this.torneosJugados>19) {
                    if (this.olimpicos == "Oro") {
                        this.probabilidad = (float) (0.8);
                    //    this.setProbabilidad ((float)(0.8));
                    } else {
                        this.setProbabilidad ((float) (0.65));
                    }
                    
                } else {
                    this.setProbabilidad ((float) (0.5));
                }
            } else {
                if (this.torneosJugados <= 18 && this.doblesFaltas > 5) {
                    this.setProbabilidad ((float) (0.5));
                    
                } else {
                    this.setProbabilidad ((float) (0.6)); 
    
                }
            }
   
        } else {
            if (this.olimpicos == "Oro") {
                if (this.pg > this.pp && this.torneosJugados > 17) {
                    if (this.doblesFaltas < 4 || this.saquesPerfectos > 7) {
                        this.setProbabilidad ((float) (0.8));
                        
                    } else {
                        this.setProbabilidad ((float) (0.7));
                        
                    }
                    
                } else {
                    if (this.rankingATP > 2400) {
                        this.setProbabilidad ((float) (0.65));
                        
                    } else {
                        this.setProbabilidad ((float) (0.55));
                        
                    }
                    
                }
            } else {
                if (this.rankingATP > 2200 || this.torneosJugados > 18) {
                    if (this.doblesFaltas < 4 && this.pg > this.pp) {
                        this.setProbabilidad ((float) (0.55));
                        
                    } else {
                        this.setProbabilidad ((float) (0.45));
                        
                    }
                    
                } else {
                    this.setProbabilidad ((float) (0.35));
                    
                }

            }

        }
        System.out.println("******************Jugador después*****************");
        this.mostrarJugador();
        

    }
    
    
    //4. Getters
    public String getNombre (){
        return nombre;
    }
    public String getSexo (){
        return sexo;
    }
    public int getPg (){
        return pg;
    }
    public int getPp (){
        return pp;
    }
    public String getOlimpicos (){
        return olimpicos;
    }
    public int getRankingATP (){
        return rankingATP;
    }
    public int getDoblesFaltas (){
        return doblesFaltas;
    }
    public int getTorneosJugados (){
        return torneosJugados;
    }
    public int getSaquesPerfectos (){
        return saquesPerfectos;
    }
    public float getProbabilidad (){
        return probabilidad;
    }


    //5. Setters
    public void setProbabilidad(float probabilidad) {
        this.probabilidad = probabilidad;
    }

}

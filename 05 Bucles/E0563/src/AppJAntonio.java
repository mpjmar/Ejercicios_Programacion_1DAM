public class AppJAntonio {
    public static final String CLEAN_SCREEN = "\033[H\033[2J";
    public static String pintaFilaDePiramide(int altura, int fila, char fondo, char contenido){
        String resultado = "";
        if(fila>=1){
            resultado += pintaCaracteres(altura-fila, fondo);            
            resultado += pintaCaracteres(2*fila-1, contenido);                        
            resultado += pintaCaracteres(altura-fila, fondo);
        }
        else{
            resultado += pintaCaracteres(2*altura-1, fondo);        
        }
        return resultado;
    }

    public static String pintaCaracteres(int espacios, char character){
        String resultado = "";
        for(int i=1;i<=espacios;i++)
                resultado += character;
        return resultado;
    }
    public static void main(String[] args)  throws Exception {

        int alt1 = 1;
        int alt2 = 10;
        int espacios = 0;
        int paso = 1;        
        char fondo = '░';
        char contenido = '█';
        
        do{
            
            for(int i=(paso>0)?1:Math.max(alt1, alt2);
                (paso>0)?i<=Math.max(alt1, alt2):i>=0;
                i+=paso){
                if(alt1>=alt2){
                    System.out.print(pintaFilaDePiramide(alt1, i, fondo, contenido));
                    System.out.print(pintaCaracteres(espacios, fondo));
                    System.out.print(pintaFilaDePiramide(alt2, i-(alt1-alt2), fondo, contenido));                
                }
                else{
                    System.out.print(pintaFilaDePiramide(alt1, i-(alt2-alt1), fondo, contenido));
                    System.out.print(pintaCaracteres(espacios, fondo));
                    System.out.print(pintaFilaDePiramide(alt2, i, fondo, contenido));
                }
                System.out.println();
            }
            Thread.sleep(100);
            System.out.print(CLEAN_SCREEN);    
            alt1++;
            if(alt1==11) alt1=1;
            alt2--;        
            if(alt2==0) alt2=10;

        }while(true);
    }      
}

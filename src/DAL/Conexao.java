package DAL;

import java.sql.*; 

public class Conexao {
    public Conexao() {
        this.servidor = "b0ct7gpszqljrkihasaa-mysql.services.clever-cloud.com";
        this.porta = "3306";
        this.bancoDados = "b0ct7gpszqljrkihasaa";
        this.usuario = "ufjxrkklmrtvulik";
        this.senha = "e89vbO8hjokn9h1EFndV";
    }
    
    public Conexao(String servidor, String porta, String bancoDados, String usuario, String senha) {
        this.servidor = servidor;
        this.porta = porta;
        this.bancoDados = bancoDados;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    private String servidor;
    private String porta;
    private String bancoDados;
    private String usuario;
    private String senha;
    
    private Connection cnn;
    
    public Connection getCnn() {
        return this.cnn;
    }
    
    public void setCnn(Connection value) {
        this.cnn = value;
    }
    
    protected void abrir() {
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            this.cnn = DriverManager.getConnection(  
            "jdbc:mysql://" + this.servidor + ":" + this.porta + "/" + this.bancoDados + "",this.usuario,this.senha);  
        } 
        catch(Exception e)
        { 
            System.out.println(e);
        }  
    }
    
    protected boolean manutencao(PreparedStatement stmt) {
        /*try{  
            abrir();
            
            PreparedStatement stmt=con.prepareStatement("insert into Estado values(?,?,?,?)");  
            stmt.setInt(1,46);//1 specifies the first parameter in the query  
            stmt.setString(2,"Teste");  
            stmt.setString(3,"TE");  
            stmt.setInt(4,1);
            
  
            int i=stmt.executeUpdate();  
            System.out.println(i+" records inserted");  
        }catch(Exception e){ System.out.println(e);}*/
        return false;
    }
    
    protected void fechar() {
        try {
            cnn.close();
        } 
        catch(Exception e)
        { 
            System.out.println(e);
        }  
    }
    
}


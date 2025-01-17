package Models;

import Logs.Logs;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.ini4j.Ini;

public class  DataBaseModel {
    private String server = "";
    private String port = "";
    private String dbName = "";
    private String user = "";
    private String password = "";
    Logs logs = new Logs();

    public void initializer() {
        try { 
           Ini ini = new Ini(new File("./db_config.ini"));
           server = ini.get("prod_credentials", "server");
           port = ini.get("prod_credentials", "port");
           dbName = ini.get("prod_credentials", "database");
           user = ini.get("prod_credentials", "user");
           password = ini.get("prod_credentials", "password");

        }
        catch (IOException e) {
            logs.saveLogs("Erro ao iniciar Banco de dados.");
            e.printStackTrace();
        }
    }

    public Map makeSelectQuery(String query) {
        String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s", server, port, dbName, user, password);
        Map<String, String> map = new HashMap<>();
        try (Connection c = DriverManager.getConnection(url); Statement smt = c.createStatement()) {
            ResultSet rs = smt.executeQuery(query);

            while (rs.next()) {
                ResultSetMetaData rsMetaData = rs.getMetaData();
                String b = rsMetaData.getColumnCount() >= 2 ? rs.getString(2) : "";
                String a = rsMetaData.getColumnCount() >= 3 ? rs.getString(3) : "";
                map.put("label1", rs.getString(1));
                map.put("label2", b);
                map.put("label3",a);
            }
            return map;

        } catch (SQLException e) {
            e.printStackTrace();
            logs.saveLogs("Erro ao fazer consulta.");
        }

        return map;
    }
    public void makeQueryWithoutReturn(String query){
        String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s", server, port, dbName, user, password);
        try (Connection c = DriverManager.getConnection(url); Statement smt = c.createStatement()) {
            smt.execute(query);

        }catch (SQLException e) {
            e.printStackTrace();
            logs.saveLogs("Erro ao realizar inser��o no banco.");
        }

        }
        public String makeCalibrateSelect(String fkMaquina){
            String url = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s", server, port, dbName, user, password);
            String query = String.format("select checada from [dbo].[maquina] where id_maquina = %s", fkMaquina);
            String response ="";
            try (Connection c = DriverManager.getConnection(url); Statement smt = c.createStatement()) {
                ResultSet rs = smt.executeQuery(query);

                while (rs.next()) {
                    response = rs.getString(1);
                }
                return response;


            } catch (SQLException e) {
                e.printStackTrace();
                logs.saveLogs("Erro ao iniciar configuracao na maquina.");
            }
            return response;

    }
}


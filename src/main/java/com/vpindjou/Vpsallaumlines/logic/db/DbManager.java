package com.vpindjou.Vpsallaumlines.logic.db;


import com.vpindjou.Vpsallaumlines.model.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;
import java.util.List;


public class DbManager {


    //region 0.Konstanten
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

    private static final String DB_LOCAL_SERVER_IP_ADDRESS = "localhost";
    private static final String DB_LOCAL_NAME = "/vpsallaumlines";

    private static final String DB_LOCAL_CONNECTION_URL =
            "jdbc:mariadb://" + DB_LOCAL_SERVER_IP_ADDRESS + DB_LOCAL_NAME;

    private static final String DB_LOCAL_USER_NAME = "root";
    private static final String DB_LOCAL_USER_PW = "";


    //endregion

    //region 1. Decl. and Init Attribute
    private static DbManager instance;
    /**
     * Zugriff auf die Datenbanktablle tblUser
     */
    private DaoTracks daoTracks;
    //endregion

    //region 2. Konstruktoren

    /**
     * Standardkonstruktor
     */
    private DbManager() {
        this.daoTracks = new DaoTracks();
    }

    //endregion

    //region 3. Get Instanze

    /**
     * Gibt einzige Instanz zurück
     *
     * @return instance : DbManager : Einzige Instanz
     */
    public static synchronized DbManager getInstance() {
        if (instance == null) {
            instance = new DbManager();
        }

        return instance;
    }

    //endregion

    //region 4. Database Connection

    /**
     * Gibt eine generiert Datenbankverbindung mit Lese(r) als auch Schreibrechten(w)
     * zurueckt oder null sollte etwas schiefgelaufen sein.
     *
     * @return rwDbConnection : {@link Connection} : Verbindung zur Datenbank mit rw - Rechten
     */
    private Connection getRwDbConnection() throws Exception {
        Connection rwDbConnection = null;

        try {
            //: Registeren des JDBC driver
            Class.forName(JDBC_DRIVER);

            //2. Offenen einer Verbindung
            rwDbConnection = DriverManager.getConnection(DB_LOCAL_CONNECTION_URL, DB_LOCAL_USER_NAME, DB_LOCAL_USER_PW);

        } catch (SQLNonTransientConnectionException sqlNoConnectionEx) {
            throw new Exception("Keine Datenbankverbindung");
        } catch (ClassNotFoundException classNotFoundEx) {
            throw new Exception("JDBC Treiber konnte nicht geladen werden");
        }

        return rwDbConnection;
    }

    /**
     * Checkt ob die Datenbank online ist oder nicht
     *
     * @return isOnline : boolean : true : Dbist Online : false nicht
     */
    public boolean isDatabaseOnline() {
        boolean isOnline = true;
        try {
            this.getRwDbConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
            isOnline = false;
        }
        return isOnline;
    }
    //endregion


    //region 5. CRUD -Opeations User

    /**
     * Einfuegen eines einzelen {@link Track}s in die Datenbank
     *
     * @param trackToInsert : {@link Track} : Zum einfuegen in die Datenbank
     */
    public void insertTripIntoDbTbl(Track trackToInsert) {

        try {
            if (this.isDatabaseOnline()) {
                //Neue Verbindung erstellen
                this.daoTracks.insertDataRecordIntoDbTbl(this.getRwDbConnection(), trackToInsert);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Einfuegen meherer {@link Track} in Datenbank
     *
     * @param tracksToInsert : {@link List} - {@link Track} : Reise zum einfuegen in die Datenbannk
     */
    public void insertTracksIntoDbTbl(List<Track> tracksToInsert) {

        try {
            if (this.isDatabaseOnline()) {
                this.daoTracks.insertDataRecordsIntoDbTbl(this.getRwDbConnection(), tracksToInsert);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }



    /**
     * Liest alle Daten aus der Testtabelle aus
     *
     * @return allUsersFromDbTable : {@link List} - {@link Track}: Alle Noizen aus Db-Tabelle
     */
    public List<Track> getAllTracksFromDb() {
        //Neue Verbindung erstellen
        List<Track> allTracksFromDb = new ArrayList<>();

        try {
            if (this.isDatabaseOnline()) {
                allTracksFromDb = this.daoTracks.getAllDataRecordsFromDbTbl(this.getRwDbConnection());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return allTracksFromDb;
    }



    /**
     * Liest eine bestimmtte Track aus der Datenbank aus.
     *
     * @param trackId : int : Id der Noiz die auslgesen werden soll
     *
     * @return specificTripFromDbById : {@link Track} : Ausgelsene Reise oder ein leeres Objekt
     * sollte die Reise nicht gefunden werden.
     */
    public Track getTrackById(int  trackId) {
        Track specificTrackFromDbById = new Track();

        try {
            if (this.isDatabaseOnline()) {
                //Neue Verbindung erstellen
                specificTrackFromDbById =
                        this.daoTracks.getSpecificDataRecordFromDbTblById(this.getRwDbConnection(), trackId);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return specificTrackFromDbById;
    }


    /**
     * Updated den mitgegeben TripLernideen in der Datenbank.
     *
     * @param trackToUpdate : {@link Track} : Reise deren Daten geaendert werden sollen.
     */
    public void updateTripInDbTbl(Track trackToUpdate) {
        try {
            if (this.isDatabaseOnline()) {
                //Neue Verbindung erstellen
                this.daoTracks.updateDataRecordIntoDbTbl(this.getRwDbConnection(), trackToUpdate);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Updated der mitgegeben Reisen in der Datenbank.
     *
     * @param tracksToUpdate : {@link List} - {@link Track} : Reisen deren Daten geaendert werden sollen.
     */
    public void updateTracksInDbTbl(List<Track> tracksToUpdate) {
        try {
            if (this.isDatabaseOnline()) {
                //Neue Verbindung erstellen
                this.daoTracks.updateDataRecordsIntoDbTbl(this.getRwDbConnection(), tracksToUpdate);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Loescht den {@link Track} mit der uebergenen id aus
     * der Datenbanktabelle
     *
     * @param trackId : int : Id der {@link Track} die geloescht werden soll
     */
    public void deleteTrackInDbTblById(int trackId) {
        //Neue Verbindung erstellen
        try {
            if (this.isDatabaseOnline()) {
                this.daoTracks.deleteDataRecordInDbTblById(this.getRwDbConnection(), trackId);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    //endregion



}

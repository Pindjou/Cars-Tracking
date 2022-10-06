package com.vpindjou.Vpsallaumlines.logic.db;

import com.vpindjou.Vpsallaumlines.model.Track;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.vpindjou.Vpsallaumlines.logic.db.ASqlKeyWords.SELECT_ALL_DATA_FROM;

public class DaoTracks {
    private static final String TABLE_NAME = "tracks";
    private static final String COL_NAME_TRACK_ID = "_trackId";

    public void insertDataRecordIntoDbTbl(Connection rwDbConnection, Track trackToInsert) {
    }

    public void insertDataRecordsIntoDbTbl(Connection rwDbConnection, List<Track> tracksToInsert) {
    }

    public List<Track> getAllDataRecordsFromDbTbl(Connection rwDbConnection) {
        List<Track> allTracksFromDbTable = new ArrayList<>();


        Statement dbStatementToExecute = null;

        try {
            //1. Rw Db Connection ist bereits vom DbManger geoeffenent und Integriert

            //2. Geneieren des Statenements
            dbStatementToExecute = rwDbConnection.createStatement();

            //3. Query generieren und absetzen und Ergebnismenge merken
            String strSqlStmtGetAll = SELECT_ALL_DATA_FROM + TABLE_NAME;


            ResultSet resultSetFromExecutedQuery = dbStatementToExecute.executeQuery(strSqlStmtGetAll);

            //4. ResultSet == Ergebnismenge durchlaufen bis kein Datensaezte mehr da sind
            while (resultSetFromExecutedQuery.next()) {

                //5. Aus der Ergebenismenge einen User beschafften
                Track trackFromDbTable = this.getModelFromResultSet(resultSetFromExecutedQuery);

                //6. Modelobjekt zur passenden Liste adden
                allTracksFromDbTable.add(trackFromDbTable);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (dbStatementToExecute != null) {
                //5. Schliessen der des Statements
                try {
                    dbStatementToExecute.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }

            if (rwDbConnection != null) {
                //6. Schliessen der Verbindung
                try {
                    rwDbConnection.close();
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
        }

        return allTracksFromDbTable;

    }




    //endregion

    //region Model aus ResultSet Formen

    /**
     * Nimmt die Ergebnismenge und formt ein konkretes Model daraus
     *
     * @param currentResultSet : {@link ResultSet} : Ergebnismenge der aktuellen Abfrage
     *
     * @return trip : {@link Track} : Model abgeleitet von der Basisklasse
     *
     * @throws Exception
     */

    private Track getModelFromResultSet(ResultSet resultSetFromExecutedQuery) {
        //Index auslesen
        final int iColumnIndexTrackId          = currentResultSet.findColumn(COL_NAME_TRACK_ID);
        final int iColumnIndexName        = currentResultSet.findColumn(COL_NAME_NAME);
        final int iColumnIndexDescription = currentResultSet.findColumn(COL_NAME_DESCRIPTION);
        final int iColumnIndexTaxPrice    = currentResultSet.findColumn(COL_NAME_TAX_PRICE);
        final int iColumnIndexIsUploaded  = currentResultSet.findColumn(COL_NAME_IS_UPLOADED);

        //6. Durch Auswahl des Datentyps und angabe des Spaltenindizes auselsen der Daten
        int trackId = currentResultSet.getInt(iColumnIndexTrackId);

        String  strName        = currentResultSet.getString(iColumnIndexName);
        String  strDescription = currentResultSet.getString(iColumnIndexDescription);

        double  dblTaxPrice    = currentResultSet.getDouble(iColumnIndexTaxPrice);

        boolean isUploaded     = currentResultSet.getBoolean(iColumnIndexIsUploaded);


        //7. Neues Modelobjekt generieren
        Track trackFromDb = new Track();

        trackFromDb.setId(trackId);

        trackFromDb.setName(strName);
        trackFromDb.setDescription(strDescription);
        trackFromDb.setTaxPrice(dblTaxPrice);
        trackFromDb.setUploaded(isUploaded);


        return trackFromDb;

    }

    public Track getSpecificDataRecordFromDbTblById(Connection rwDbConnection, int trackId) {
    }

    public void updateDataRecordIntoDbTbl(Connection rwDbConnection, Track trackToUpdate) {
    }

    public void updateDataRecordsIntoDbTbl(Connection rwDbConnection, List<Track> tracksToUpdate) {
    }

    public void deleteDataRecordInDbTblById(Connection rwDbConnection, int trackId) {
    }
}

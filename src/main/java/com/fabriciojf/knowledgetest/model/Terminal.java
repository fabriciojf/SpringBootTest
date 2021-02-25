package com.fabriciojf.knowledgetest.model;

import com.fabriciojf.knowledgetest.error.ObjectNotCorrespondingError;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class Terminal
 * @since 24/02/2021
 */
@Entity
public class Terminal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int logic;
    private String serial;
    private String model; // falta documentacao deste campo
    private String version;
    private int sam;
    private String ptid;
    private int plat;
    private int mxr;
    private String mxf;
    
    @JsonProperty("VERFM")
    private String verfm;

    public void adaptJsonObject(JSONObject json) {

        try {
            this.logic = json.getInt("logic");
            this.serial = json.getString("serial");
            this.model = json.getString("model");
            this.version = json.getString("version");
            this.sam = json.getInt("sam");
            this.ptid = json.getString("ptid");
            this.plat = json.getInt("plat");
            this.mxr = json.getInt("mxr");
            this.mxf = json.getString("mxf");
            this.verfm = json.getString("VERFM");
        } catch (JSONException ex) {
            throw new ObjectNotCorrespondingError(
                    "Falha ao adaptar o Objeto Json ao modelo Terminal");
        }
    }

    public int getLogic() {
        return logic;
    }

    public void setLogic(int logic) {
        this.logic = logic;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getSam() {
        return sam;
    }

    public void setSam(int sam) {
        this.sam = sam;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public int getPlat() {
        return plat;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public int getMxr() {
        return mxr;
    }

    public void setMxr(int mxr) {
        this.mxr = mxr;
    }

    public String getMxf() {
        return mxf;
    }

    public void setMxf(String mxf) {
        this.mxf = mxf;
    }

    public String getVerfm() {
        return verfm;
    }

    public void setVerfm(String verfm) {
        this.verfm = verfm;
    }

}

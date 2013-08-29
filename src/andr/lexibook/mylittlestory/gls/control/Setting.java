package andr.lexibook.mylittlestory.gls.control;

import andr.lexibook.mylittlestory.gls.model.ReadMode;
import andr.lexibook.mylittlestory.gls.ui.R;
import andr.lexibook.mylittlestory.gls.util.ReadModeToFile;
import android.app.Activity;
import android.content.Context;

/**
 * Created by rain on 5/20/13.
 */
public class Setting {

    private Activity ctx;
    private static Setting instance;
    private ReadMode readMode;
    private ReadModeToFile io;
    private boolean ifOOM = false;

    /**
     * change language
     */
    public final int ENGLISH = 0;
    public final int FRANCH = 1;
    public final int EUTSCH = 2;
    public final int ESPANOL = 3;
    public final int ITALIANO = 4;

    public String eng;
    public String fra;
    public String deu;
    public String esp;
    public String ita;

    private Setting(Context ctx) {
        io = new ReadModeToFile(ctx);
        readMode = io.get();
        eng = ctx.getString(R.string.lang_english);
        fra = ctx.getString(R.string.lang_franch);
        deu = ctx.getString(R.string.lang_eutsch);
        esp = ctx.getString(R.string.lang_espanol);
        ita = ctx.getString(R.string.lang_italiano);
    }

    public static Setting getInstance(Context ctx) {
        if (instance == null)
            instance = new Setting(ctx);
        return instance;
    }

    public ReadMode getReadMode() {
        return this.readMode;
    }

    public void save() {
        io.save(this.readMode);
    }

    public String getLang() {
        return readMode.getLang();
    }

    public int getLangId() {
        return checkLangToId(readMode.getLang());
    }

    public void setLang(String lang) {
        this.readMode.setLang(lang);
    }

    public void setLang(int langId) {
        this.readMode.setLang(checkIdToLang(langId));
    }

    public void setFirst(boolean isFirst) {
        this.readMode.setFirst(isFirst);
    }

    public boolean isFirst() {
        return this.readMode.isFirst();
    }

    public boolean isAuto() {
        return this.readMode.isAuto();
    }

    public void setAuto(boolean isAuto) {
        this.readMode.setAuto(isAuto);
    }

    public boolean isOOM() {
        return ifOOM;
    }

    public void setOOM(boolean ifOOM) {
        this.ifOOM = ifOOM;
    }

    private String checkIdToLang(int langId) {
        switch (langId) {
            case ENGLISH:
                return eng;
            case FRANCH:
                return fra;
            case EUTSCH:
                return deu;
            case ESPANOL:
                return esp;
            case ITALIANO:
                return ita;
            default:
                return eng;
        }
    }

    private String toAppLangChange(int langId) {
        switch (langId) {
            case ENGLISH:
                return ctx.getString(R.string.app_english);
            case FRANCH:
                return ctx.getString(R.string.app_franch);
            case EUTSCH:
                return ctx.getString(R.string.app_eutsch);
            case ESPANOL:
                return ctx.getString(R.string.app_espanol);
            case ITALIANO:
                return ctx.getString(R.string.app_italiano);
            default:
                return ctx.getString(R.string.app_english);
        }
    }

    public int checkLangToId(String lang) {
        if (lang.equals(eng))
            return ENGLISH;
        if (lang.equals(fra))
            return FRANCH;
        if (lang.equals(deu))
            return EUTSCH;
        if (lang.equals(esp))
            return ESPANOL;
        if (lang.equals(ita))
            return ITALIANO;
        return ENGLISH;
    }

}

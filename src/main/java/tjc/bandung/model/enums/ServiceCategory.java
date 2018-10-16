package tjc.bandung.model.enums;

public enum ServiceCategory {
    UMUM_RABU("rabu"),
    UMUM_JUMAT("jumat"),
    UMUM_SABAT_PAGI("sabat_pagi"),
    UMUM_SABAT_SORE("sabat_sore"),
    SPA_SABAT_INDRIA("sabat_indria"),
    SPA_SABAT_MADYA("sabat_madya"),
    SPA_SABAT_REMAJA("sabat_remaja");
//    add following sunday school and youth service here

    private String code;

    private ServiceCategory(final String code) {
        this.code = code;
    }

    public static ServiceCategory fromCode(final String code) {
        for (final ServiceCategory status : ServiceCategory.values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new UnsupportedOperationException("The code " + code + " is not supported!");
    }

    public String getCode() {
        return code;
    }
}

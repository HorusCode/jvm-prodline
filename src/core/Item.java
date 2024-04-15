package core;

import java.util.Date;

public interface Item {
    String MANUFACTURER = "OracleProduction";

    void setProductionNumber(int productionNumber);

    void setName(String name);

    String getName();

    Date getManufactureDate();

    int getSerialNumber();

}

/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.portfolio.collateral.data;

import java.math.BigDecimal;
import java.util.Collection;

import org.mifosplatform.infrastructure.codes.data.CodeValueData;
import org.mifosplatform.organisation.monetary.data.CurrencyData;

/**
 * Immutable data object for Collateral data.
 */
public class CollateralData {

    private final Long id;
    private final CodeValueData type;
    private final CodeValueData goldfine;
    private final CodeValueData jewellery;
    private final BigDecimal value;
    private BigDecimal gross;
    private BigDecimal impurity;
    private BigDecimal net;
    private BigDecimal stone;
    private final String description;
    @SuppressWarnings("unused")
    private final Collection<CodeValueData> allowedCollateralTypes;
    private final Collection<CodeValueData>allowedGoldfineTypes;
    private final Collection<CodeValueData>allowedJewelleryTypes;
    private final CurrencyData currency;

    public static CollateralData instance(final Long id, final CodeValueData type,final CodeValueData goldfine, final CodeValueData jewellery,final BigDecimal value,final BigDecimal gross,final BigDecimal impurity,final BigDecimal net, final BigDecimal stone, final String description,
            final CurrencyData currencyData) {
        return new CollateralData(id, type,goldfine,jewellery, value,gross,impurity,net,stone, description, currencyData);
    }

    public static CollateralData template(final Collection<CodeValueData> codeValues, final Collection<CodeValueData> goldfineValues, final Collection<CodeValueData> jewelleryValues) {
        return new CollateralData(null, null, null, null, null, null, null, null,null, null, null, codeValues,goldfineValues, codeValues, jewelleryValues, goldfineValues, jewelleryValues);
    }

    private CollateralData(final Long id, final CodeValueData type,final CodeValueData goldfine, final CodeValueData jewellery, final BigDecimal value,final BigDecimal gross,final BigDecimal impurity, final BigDecimal net, final BigDecimal stone, final String description,
            final CurrencyData currencyData ) {
        this.id = id;
        this.type = type;
        this.goldfine = goldfine;
        this.jewellery = jewellery;
        this.value = value;
        this.gross = gross;
        this.impurity = impurity;
        this.net = net;
        this.stone = stone;
        this.description = description;
        this.currency = currencyData;
        this.allowedCollateralTypes = null;
        this.allowedGoldfineTypes = null;
        this.allowedJewelleryTypes = null;
    }

    private CollateralData(final Long id, final CodeValueData type,final CodeValueData goldfine,final CodeValueData jewellery, final BigDecimal value,final BigDecimal gross, final BigDecimal impurity, final BigDecimal net, final BigDecimal stone,final String description,
            final CurrencyData currencyData,final Collection<CodeValueData> codeValues,final Collection<CodeValueData> goldfineValues,final Collection<CodeValueData> allowedCollateralTypes, final Collection<CodeValueData> jewelleryValues, final Collection<CodeValueData> allowedGoldfineTypes, final Collection<CodeValueData>allowedJewelleryTypes) {
        this.id = id;
        this.type = type;
        this.goldfine = goldfine;
        this.jewellery = jewellery;
        this.value = value;
        this.gross = gross;
        this.impurity = impurity;
        this.net = net;
        this.stone = stone;
        this.description = description;
        this.currency = currencyData;
        this.allowedCollateralTypes = allowedCollateralTypes;
        this.allowedGoldfineTypes = allowedGoldfineTypes;
        this.allowedJewelleryTypes = allowedJewelleryTypes;
    }

    public CollateralData template(final CollateralData collateralData, final Collection<CodeValueData> codeValues, final Collection<CodeValueData> goldfineValues, final Collection<CodeValueData> jewelleryValues) {
        return new CollateralData(collateralData.id, collateralData.type,collateralData.goldfine, collateralData.jewellery,collateralData.value, collateralData.gross,collateralData.impurity, collateralData.net,collateralData.stone,collateralData.description,
                collateralData.currency, null, goldfineValues, codeValues, jewelleryValues, null, null);
    }
}
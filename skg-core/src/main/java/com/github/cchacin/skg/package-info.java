@Style(
        defaultAsDefault = true,
        typeBuilder = "*InternalBuilder",
        implementationNestedInBuilder = true,
        validationMethod = Style.ValidationMethod.NONE,
        jacksonIntegration = false,
        of = "new",
        allParameters = true,
        jdkOnly = true)
package com.github.cchacin.skg;

import org.immutables.value.Value.Style;
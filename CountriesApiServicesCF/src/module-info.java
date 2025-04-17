module countries.api.services {
    // Existing requires statements if any
    requires com.fasterxml.jackson.databind;
    
    // Export your models package to Jackson
    exports com.countries.modelos;
    
    // If you have other exports, keep them
    exports com.countries.apiAccess;
    
    // If you're using Jackson annotations, you might need this
    opens com.countries.modelos to com.fasterxml.jackson.databind;
}
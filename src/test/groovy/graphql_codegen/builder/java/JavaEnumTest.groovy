package graphql_codegen.builder.java

import spock.lang.Specification

class JavaEnumTest extends Specification{

    def "enum sample"() {
        def javaEnum = JavaEnum.newJavaEnumBuilder()
                .withDescription("Ship type")
                .withName("Ship")
                .withMembers(Arrays.asList("FIGHTER", "VESSEL"))
                .withPackagePath("com.disney.starwars")
                .build();
        expect:
        javaEnum.code() == getFilledTemplate()
    }

    def getFilledTemplate() {
        return "package com.disney.starwars;\n" +
                "\n" +
                "/**\n" +
                "* Ship type\n" +
                "**/\n" +
                "public enum Ship {\n" +
                "\n" +
                "    FIGHTER, \n" +
                "    VESSEL\n" +
                "\n" +
                "    private String value;\n" +
                "\n" +
                "    Ship (String value) {\n" +
                "    this.value = value;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public String toString() {\n" +
                "        return value;\n" +
                "    }\n" +
                "}";
    }
}

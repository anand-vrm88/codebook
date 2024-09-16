package com.codebook.interview;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionLibrary {

    static Map<String, List<Function>> basicFunctionMap = new HashMap<>();
    static Map<String, List<Function>> variadicFunctionMap = new HashMap<>();

    static void register(List<Function> functions){
        for (Function function : functions) {
            if(function.isVariadic){
                String key = buildVariadicKey(function.argumentTypes);
                registerFunction(variadicFunctionMap, key, function);
            } else {
                String key = buildBasicKey(function.argumentTypes);
                registerFunction(basicFunctionMap, key, function);
            }
        }
    }

    static List<Function> findFunctions(List<String> argumentTypes) {
        String basicKey = buildBasicKey(argumentTypes);
        String variadicKey = buildCompressedVariadicKey(argumentTypes);
        List<Function> functions = new LinkedList<>();
        List<Function> functionList1 = basicFunctionMap.get(basicKey);
        if(Objects.nonNull(functionList1)){
            functions.addAll(functionList1);
        }
        List<Function> functionList2 = variadicFunctionMap.get(variadicKey);
        if (Objects.nonNull(functionList2)) {
            functions.addAll(functionList2);
        }
        return functions;
    }

    public static void main(String[] args) {
        Function functionA = new Function("funcA", Arrays.asList("Integer", "Boolean"), false);
        Function functionB = new Function("funcB", Collections.singletonList("Integer"), false);
        Function functionC = new Function("funcC", Arrays.asList("Integer", "Boolean"), true);

        register(Arrays.asList(functionA, functionB, functionC));

        List<Function> functions = findFunctions(Arrays.asList("Integer", "Boolean", "Boolean"));

        assert functions.stream().map(fun -> fun.name).collect(Collectors.toList()).equals(Collections.singletonList("funcA"));
    }

    private static void registerFunction(Map<String, List<Function>> variadicFunctionMap, String key, Function function) {
        List<Function> functionList = variadicFunctionMap.getOrDefault(key, new LinkedList<>());
        functionList.add(function);
        variadicFunctionMap.put(key, functionList);
    }

    private static String buildBasicKey(List<String> argumentTypes){
        return String.join(":", argumentTypes);
    }

    private static String buildVariadicKey(List<String> argumentTypes){
        return buildBasicKey(argumentTypes) + ":*";
    }

    private static String buildCompressedVariadicKey(List<String> argumentTypes) {
        int index = argumentTypes.size() - 1;
        String argumentTypeToCompress = argumentTypes.get(index);
        while (--index >= 0) {
            if(!argumentTypes.get(index).equals(argumentTypeToCompress)){
                break;
            }
        }

        List<String> derivedVariadicArgumentTypes = new LinkedList<>();
        for(int listIndex = 0; listIndex <= index; listIndex++){
            derivedVariadicArgumentTypes.add(argumentTypes.get(listIndex));
        }

        derivedVariadicArgumentTypes.add(argumentTypeToCompress);

        return String.join(":", derivedVariadicArgumentTypes) + ":*";
    }
}

class Function {
    String name;
    List<String> argumentTypes;
    boolean isVariadic;

    public Function(String name, List<String> argumentTypes, boolean isVariadic) {
        this.name = name;
        this.argumentTypes = argumentTypes;
        this.isVariadic = isVariadic;
    }
}

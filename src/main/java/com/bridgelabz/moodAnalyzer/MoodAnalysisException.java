package com.bridgelabz.moodAnalyzer;

class MoodAnalysisException extends Exception {
    enum MyException_Type{
        EMPTY,NULL,CLASSNOTFOUND;
    }
    MyException_Type type;
    MyException_Type exceptionMessage;
    MoodAnalysisException(MyException_Type type,String message) {
        super(message);
        this.type=type;
        System.out.println(message);
    }
}

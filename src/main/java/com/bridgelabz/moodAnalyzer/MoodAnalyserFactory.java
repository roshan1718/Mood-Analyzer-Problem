package com.bridgelabz.moodAnalyzer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    // set the field value
    public static String setFieldMoodAnalyser(MoodAnalyzer mood,String fieldName,String fieldValue){
        try{
            Field field = mood.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(mood,fieldValue);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    // Return message


    public static String moodAnalyzer(MoodAnalyzer message,String methodName) throws MoodAnalysisException {
        try {
            return (String)message.getClass().getMethod(methodName).invoke(message);
        } catch (Exception e) {
            //throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        }
        return null;
    }
    // Return class object
    public static Constructor<?> getConstructor(String className,Class methodName) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            return moodAnalyzer.getConstructor(methodName);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        }
    }

    // Return class object with parameter constructor
    public static Object getParameterizConstructor(String className,Class methodName,String mood) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            Constructor<?> constructorMood = moodAnalyzer.getConstructor(methodName);
            return constructorMood.newInstance(mood);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        } catch (IllegalAccessException |InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return ("mood");
    }


    // Return class object when class name improper with parameter
    public static Object getClassNameImproperWithParameter(String className,Class methodName,String mood) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            Constructor<?> construct = moodAnalyzer.getConstructor(methodName);
            return construct.newInstance(mood);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method name");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return(mood);
    }

    // Return constructor instance
    public static <MoodAnalyzer> MoodAnalyzer createMoodAnalyzer() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName("MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzer.getConstructor();
            Object instance = moodConstructor.newInstance();
            return (MoodAnalyzer) instance;

        }catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class name");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid Class name");
        }catch (IllegalAccessException |InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }


 }

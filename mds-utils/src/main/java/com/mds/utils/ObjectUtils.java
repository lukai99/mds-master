package com.mds.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;


public class ObjectUtils {
	
	public static void copyProperty(Object lessObj,Object oldObj) throws Exception{
		Class<? extends Object> lessClazz = lessObj.getClass();
		Class<? extends Object> oldClazz = oldObj.getClass();
		//获取所有属性
		Field[] lessFields = lessClazz.getDeclaredFields();
		Field[] oldFields = oldClazz.getDeclaredFields();
		for(int i=0;i<lessFields.length;i++){
			Field lessObjField = lessFields[i];
			String lessName = lessObjField.getName();
			String lessType = lessObjField.getGenericType().toString();
			
			for(int j=0;j<oldFields.length;j++){
				Field oldObjField = oldFields[j];
				String oldName = oldObjField.getName();
				String oldType = oldObjField.getGenericType().toString();
				if(lessName.equals(oldName)&&lessType.equals(oldType)){
					//String 类型
					if(lessType.equals("class java.lang.String")){
						Method lessMethod = lessClazz.getDeclaredMethod("get"+ObjectUtils.fristCharToUpperCase(lessName));
						String value = (String)lessMethod.invoke(lessObj);
						System.out.println("属性名称："+lessName+" = "+value+" 类型"+lessType);
						//如果源数据属性为空 则用目标数据属性填充
						if(null==value||value.isEmpty()){
							Method oldMethod = oldClazz.getDeclaredMethod("get"+ObjectUtils.fristCharToUpperCase(lessName));
							String oldValue = (String)oldMethod.invoke(oldObj);
							Method lessSetMethod = lessClazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(lessName),String.class);
							lessSetMethod.invoke(lessObj,oldValue);
						}
					//Integer 类型
					}else if(lessType.equals("class java.lang.Integer")){
						Method lessMethod = lessClazz.getDeclaredMethod("get"+ObjectUtils.fristCharToUpperCase(lessName));
						Integer value = (Integer)lessMethod.invoke(lessObj);
						System.out.println("属性名称："+lessName+" = "+value+" 类型"+lessType);
					//int 类型
					}else if(lessType.equals("int")){
						Method lessMethod = lessClazz.getMethod("get"+ObjectUtils.fristCharToUpperCase(lessName));
						Integer value = (Integer)lessMethod.invoke(lessObj);
						System.out.println("属性名称："+lessName+" = "+value+" 类型"+lessType);
					//Double 类型
					}else if(lessType.equals("class java.lang.Double")){
						Method lessMethod = lessClazz.getMethod("get"+ObjectUtils.fristCharToUpperCase(lessName));
						Double value = (Double)lessMethod.invoke(lessObj);
						System.out.println("属性名称："+lessName+" = "+value+" 类型"+lessType);
					//double 类型
					}else if(lessType.equals("double")){
						Method lessMethod = lessClazz.getMethod("get"+ObjectUtils.fristCharToUpperCase(lessName));
						Double value = (Double)lessMethod.invoke(lessObj);
						System.out.println("属性名称："+lessName+" = "+value+" 类型"+lessType);
					//Boolean 类型
					}else if(lessType.equals("class java.lang.Boolean")){
						Method lessMethod = lessClazz.getMethod("get"+ObjectUtils.fristCharToUpperCase(lessName));
						Boolean value = (Boolean)lessMethod.invoke(lessObj);
						System.out.println("属性名称："+lessName+" = "+value+" 类型"+lessType);
					}else if(lessType.equals("boolean")){
						Method lessMethod = lessClazz.getMethod(lessName);
						Boolean value = (Boolean)lessMethod.invoke(lessObj);
						System.out.println("属性名称："+lessName+" = "+value+" 类型"+lessType);
					}
				}else if(lessName.equals(oldName)&&!lessType.equals(oldType)){
					throw new Exception("属性名称一致 但是类型不相同");
				}
			}
		}
	}
	//map 赋值给实体 名称一致的话 就会进行赋值
	public static void copyMap2Entity(Map<String,Object> map,Object obj) throws Exception{
		Class<? extends Object> clazz = obj.getClass();
		Field[] objFields = clazz.getDeclaredFields();
		Set<String> set = map.keySet(); //得到所有key的集合
		for (String key : set) { 
			for(int j=0;j<objFields.length;j++){
				Field objField = objFields[j];
				String objName = objField.getName();
				String objType = objField.getGenericType().toString();
				if(key.equals(objName.toUpperCase())&&null!=map.get(key)){
					//String 类型
					if(objType.equals("class java.lang.String")){
						Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),String.class);
						objSetMethod.invoke(obj,map.get(key)+"");
					//Integer 类型
					}else if(objType.equals("class java.lang.Integer")){
						Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),Integer.class);
						objSetMethod.invoke(obj,Integer.valueOf((String) (map.get(key)+"")));
					//int 类型
					}else if(objType.equals("int")){
						Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),String.class);
						objSetMethod.invoke(obj,Integer.valueOf((String) map.get(key)));
					//Double 类型
					}else if(objType.equals("class java.lang.Double")){
						Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),Double.class);
						objSetMethod.invoke(obj,Double.valueOf((String) (map.get(key)+"")));
					//double 类型
					}else if(objType.equals("double")){
						Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),String.class);
						objSetMethod.invoke(obj,Double.valueOf((String) map.get(key)));
					//Boolean 类型
					}else if(objType.equals("class java.lang.Boolean")){
						Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),String.class);
						objSetMethod.invoke(obj,Boolean.valueOf((String) map.get(key)));
					}else if(objType.equals("boolean")){
						Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),String.class);
						objSetMethod.invoke(obj,Boolean.valueOf((String) map.get(key)));
					}else if(objType.equals("class java.util.Date")){
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						if(null!=map.get(key)&&!"".equals(map.get(key))){
							//java.sql.Date date = (java.sql.Date) map.get(key);
							String sqlDate = formatter.format((java.sql.Date) map.get(key));
							java.util.Date udate = formatter.parse(sqlDate);
							Method objSetMethod = clazz.getDeclaredMethod("set"+ObjectUtils.fristCharToUpperCase(objName),java.util.Date.class);
							objSetMethod.invoke(obj,udate);
						}
					}else{
						//throw new Exception("工具类中未定义数据类型 "+objType);
					}
				}
			}
		}
	}
	
	//第一个字母变大写
	private static String fristCharToUpperCase(String fildeName){
		  byte[] items = fildeName.trim().getBytes();
		  if(items.length <= 0){
			 try {
				throw new Exception("fristCharToUpperCase() 传入的参数不合法");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		  }
		  items[0] = (byte) ((char) items[0] - 'a' + 'A');
		  return new String(items);
		 }
	public static void main(String[] args) throws Exception {
		//Man man = new Man();
		/*man.setName("张三");
		man.setAge(20);
		man.setAdress("北京朝阳");
		man.setTel("18610475019");
		man.setDied(false);
		man.setPrice(20.20);
		man.setSex(true);
		man.setTall(165);
		man.setIsDD("DD");*/
//		Man man1 = new Man();
//		man1.setAge(20);
//		man1.setAdress("北京朝阳");
//		man1.setTel("18610475019");
//		man1.setDied(false);
//		man1.setPrice(20.20);
//		man1.setSex(true);
//		man1.setTall(165);
//		man1.setIsDD("DD");
//		try {
//			ObjectUtils.copyProperty(man, man1);
//			System.out.println(man);
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		}
	}
}

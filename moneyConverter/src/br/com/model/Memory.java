package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	
	private static final Memory instance = new Memory();

	private enum TypeCommand {
		NUMBER, BACKSPACE, CLEAR, 
		USD, EURO, POUND, YEN, AUD, CAD, SWISS, YUAN, PESO, RUBLE, LIRA, DIRHAM;
	}
	
	private List<MemoryObserver> observers = new ArrayList<>();
	
	private String typedText = "";
	private String convertedText = "";
	private boolean substitute = false;
	
	public static Memory getInstance() {
		return instance;
	}
	
	public String getTypedText() {
		return typedText.isEmpty() ? "0" : typedText;
	}
	
	public String getConvertedText() {
		return convertedText.isEmpty() ? "0" : convertedText;
	}
	
	public void addObserver(MemoryObserver o) {
		observers.add(o);
	}
	
	private TypeCommand detectTypeCommand(String command) {
		
		command = command.strip();
		
		if(typedText.isEmpty() && command == "0") {			
			return null;
		} 
		
		try {
		Integer.parseInt(command);
		return TypeCommand.NUMBER;
		} catch (NumberFormatException e) {
			
			if("AC".equals(command)) {
				return TypeCommand.CLEAR;
			} else if("U$".equals(command)) {
				return TypeCommand.USD;
			} else if("€".equals(command)) {
				return TypeCommand.EURO;
			} else if("£".equals(command)) {
				return TypeCommand.POUND;
			} else if("J¥".equals(command)) {
				return TypeCommand.YEN;
			} else if("A$".equals(command)) {
				return TypeCommand.AUD;
			}  else if("C$".equals(command)) {
				return TypeCommand.CAD;
			} else if("₣".equals(command)) {
				return TypeCommand.SWISS;
			} else if("C¥".equals(command)) {
				return TypeCommand.YUAN;
			} else if("P$".equals(command)) {
				return TypeCommand.PESO;
			} else if("₽".equals(command)) {
				return TypeCommand.RUBLE;
			} else if("₺".equals(command)) {
				return TypeCommand.LIRA;
			} else if("د".equals(command)) {
				return TypeCommand.DIRHAM;
			}  else if("⌫".equals(command) && !typedText.equals("0")) {
				return TypeCommand.BACKSPACE;
			} 
			
			
			return null;
		}
	}
	
public void processCommand(String command) {
		
		
		TypeCommand typecommand = detectTypeCommand(command);
		
		if(typecommand == null) {
			return;
		} else if(typecommand == TypeCommand.CLEAR) {
			typedText = "";
			convertedText = "";
			substitute = false;
		} else if (typecommand == TypeCommand.NUMBER) {
			typedText = substitute ? command.strip() : typedText + command.strip();
			
			substitute = false;
		} else if(typecommand == TypeCommand.USD){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 0.17594);
		} else if(typecommand == TypeCommand.EURO){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 0.1684);
		}else if(typecommand == TypeCommand.POUND){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 0.1393);
		}else if(typecommand == TypeCommand.YEN){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 26.7262);
		}else if(typecommand == TypeCommand.AUD){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 0.2781);
		}else if(typecommand == TypeCommand.CAD){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 0.2522);
		}else if(typecommand == TypeCommand.SWISS){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 0.1590);
		}else if(typecommand == TypeCommand.YUAN){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 1.2799);
		}else if(typecommand == TypeCommand.PESO){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 189.1880);
		}else if(typecommand == TypeCommand.RUBLE){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 16.0964);
		}else if(typecommand == TypeCommand.LIRA){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 6.8429);
		}else if(typecommand == TypeCommand.DIRHAM){
			double currentNum = Double.valueOf(typedText);
			convertedText = String.format("%.2f", currentNum * 0.6476);
		}else if(typecommand == TypeCommand.BACKSPACE) {
			typedText = removeLastChar(typedText);
		}else {
			substitute = true;
		}
		
		
		observers.forEach(o -> o.setValue1(getTypedText()));
		
		if(this.getConvertedText() != null) {
		observers.forEach(o -> o.setValue2(getConvertedText()));
		}
		
	}
	
public static String removeLastChar(String s) {
    return (s == null || s.length() == 0)
      ? null 
      : (s.substring(0, s.length() - 1));
}
}

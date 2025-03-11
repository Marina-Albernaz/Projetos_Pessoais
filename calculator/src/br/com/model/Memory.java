package br.com.model;

import java.util.ArrayList;
import java.util.List;

public class Memory {
	
	private enum TypeCommand  {
		CLEAR, NUMBER, DIV, MUL, SUM, SUB, EQUALS, POINT, SIGNAL;	
	};

	private static final Memory instance = new Memory();
	
	private final List<MemoryObserver> observers = new ArrayList<>();
	
	private boolean substitute = false;
	private String currentText = "";
	private String bufferText = "";
	private TypeCommand lastOp = null;
	
	private Memory() {
		
	}
	
	public static Memory getInstance() {
		return instance;
	}
	
	public String getCurrentText() {
		return currentText.isEmpty() ? "0" : currentText;
	}
	
	public void addObserver(MemoryObserver o) {
		observers.add(o);
	}
	
	public void processCommand(String command) {
		
		
		TypeCommand typecommand = detectTypeCommand(command);
		
		if(typecommand == null) {
			return;
		} else if(typecommand == TypeCommand.CLEAR) {
			currentText = "";
			bufferText = "";
			lastOp = null;
			substitute = false;
		} else if (typecommand == TypeCommand.NUMBER || typecommand == TypeCommand.POINT) {
			currentText = substitute ? command : currentText + command;
			substitute = false;
		} else if(typecommand == TypeCommand.SIGNAL){
			double currentNum = Double.valueOf(currentText);
			currentNum = currentNum * -1;
			currentText = Double.toString(currentNum).endsWith(".0") ? Double.toString(currentNum).replace(".0", "") : Double.toString(currentNum);
			
		} else {
			substitute = true;
			currentText = obtainOpsResult();
			bufferText = currentText;
			lastOp = typecommand;
		}
		
		
		observers.forEach(o -> o.alteredValue(getCurrentText()));
	}
	
	private String obtainOpsResult() {
		if(lastOp == null || lastOp == TypeCommand.EQUALS) {
			return currentText;			
		}
		
		double bufferNum = Double.valueOf(bufferText);
		double currentNum = Double.valueOf(currentText);
		
		double result = 0;
		
		if(lastOp == TypeCommand.SUM) {
			result = bufferNum + currentNum;
		} else if(lastOp == TypeCommand.SUB) {
			result = bufferNum - currentNum;
		} else if(lastOp == TypeCommand.MUL) {
			result = bufferNum * currentNum;
		} else if(lastOp == TypeCommand.DIV) {
			result = bufferNum / currentNum;
		} 
		
		String resultText = Double.toString(result);
		boolean isInteger = resultText.endsWith(".0");
		
		return isInteger ? resultText.replace(".0", "") : resultText;
		
	}

	private TypeCommand detectTypeCommand(String command) {
		
		if(currentText.isEmpty() && command == "0") {			
			return null;
		} 
		
		try {
		Integer.parseInt(command);
		return TypeCommand.NUMBER;
		} catch (NumberFormatException e) {
			
			if("AC".equals(command)) {
				return TypeCommand.CLEAR;
			} else if("÷".equals(command)) {
				return TypeCommand.DIV;
			} else if("×".equals(command)) {
				return TypeCommand.MUL;
			} else if("+".equals(command)) {
				return TypeCommand.SUM;
			} else if("-".equals(command)) {
				return TypeCommand.SUB;
			} else if(".".equals(command) && !currentText.contains(".") && !currentText.isEmpty()) {
				return TypeCommand.POINT;
			}  else if("=".equals(command)) {
				return TypeCommand.EQUALS;
			} else if("±".equals(command) && currentText != "0") {
				return TypeCommand.SIGNAL;
			}
			
			return null;
		}
	}
}

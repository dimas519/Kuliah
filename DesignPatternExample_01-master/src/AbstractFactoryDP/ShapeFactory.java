/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryDP;

/**
 *
 * @author Erwin
 */
public class ShapeFactory extends AbstractFactory{
	@Override
	public Shape getShape(String s){
		if(s.equalsIgnoreCase("rectangle")){
			return new Rectangle();
		}
		else if(s.equalsIgnoreCase("square")){
			return new Square();
		}
		return null;
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototipo;

/**
 *
 * @author Michel
 */
public class Rotator {
    private String images[] = {"ti.jpg",
            "importancia-tecnologia-da-informacao-na-empresa.jpg"};
    
private String links[] = { 
    "https://blog.ead.unipar.br/wp-content/uploads/2021/04/ti.jpg",
    "https://blog.foxmanager.com.br/wp-content/uploads/2020/06/importancia-tecnologia-da-informacao-na-empresa.jpg"}; 
    
private int selectedIndex = 0;

public String getImage(){
    return images [selectedIndex];
}
    
public String getLink(){
    return links [selectedIndex];
}

public void nextAd(){
    selectedIndex = (selectedIndex + 1) % images.length;
}
}

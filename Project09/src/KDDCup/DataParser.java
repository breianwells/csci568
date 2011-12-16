package KDDCup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class DataParser {
	
	Vector<Integer> genres;
	Vector<track> tracks;
	Vector<User> users;
	
	private void ExtractData(){
		BufferedReader read;
		String line;
		User newUser;
		int genre;
		int count;
		int track;
		int rating;
		track temp;
		String[] tokens;
		tracks=new Vector<track>();
		users=new Vector<User>();
		int i,j,k;
		try {
			read=new BufferedReader(new FileReader("track1/genreData1.txt"));
			while((line=read.readLine())!=null){
				genres.add(Integer.parseInt(line));
			}
			read.close();
			read=new BufferedReader(new FileReader("track1/albumData1.txt"));
			while((line=read.readLine())!=null){
				tokens=line.split("\\|");
				temp=new track();
				temp.ID=Integer.parseInt(tokens[0]);
				temp.genres=new Vector<Integer>();
				for(i=2;i<tokens.length;i++){
					genre=Integer.parseInt(tokens[i]);
					temp.genres.add(genres.indexOf(genre));
				}
				tracks.add(temp);
			}
			read=new BufferedReader(new FileReader("track1/trackData1.txt"));
			while((line=read.readLine())!=null){
				tokens=line.split("\\|");
				temp=new track();
				temp.ID=Integer.parseInt(tokens[0]);
				temp.genres=new Vector<Integer>();
				for(i=3;i<tokens.length;i++){
					genre=Integer.parseInt(tokens[i]);
					temp.genres.add(genres.indexOf(genre));
				}
				tracks.add(temp);
			}
			read.close();
			read=new BufferedReader(new FileReader("track1/trainIdx1.firstLines.txt"));
			while((line=read.readLine())!=null){
				System.out.println(line);
				tokens=line.split("\\|");
				newUser=new User();
				newUser.count=new Vector<Integer>();
				newUser.score=new Vector<Double>();
				for(i=0;i<genres.size();i++){
					newUser.count.add(0);
					newUser.score.add(0.0);
				}
				count=Integer.parseInt(tokens[1]);
				for(i=0;i<count;i++){
					line=read.readLine();
					tokens=line.split("\t");
					track=Integer.parseInt(tokens[0]);
					if(tokens[1].equals("None")){
						rating=0;
					}
					else{
						rating=Integer.parseInt(tokens[1])/10;
					}
					for(j=0;j<tracks.size();j++){
						if(tracks.get(j).ID==track){
							for(k=0;k<tracks.get(j).genres.size();k++){
								genre=tracks.get(j).genres.get(k);
								newUser.count.set(genre, newUser.count.get(genre)+1);
								newUser.score.set(genre, newUser.score.get(genre)+rating);
							}
							break;
						}
					}
				}
				for(i=0;i<newUser.count.size();i++){
					if(newUser.count.get(i)!=0){
						newUser.score.set(i, newUser.score.get(i)/newUser.count.get(i));
					}
				}
				System.out.println("User Complete");
				users.add(newUser);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter write;
		try {
			write=new BufferedWriter(new FileWriter("output.txt"));
			for(i=0;i<users.size();i++){
				write.write(String.valueOf(i));
				for(j=0;j<users.get(i).score.size();j++){
					write.write(',');
					write.write(String.valueOf(users.get(i).score.get(j)));
				}
				write.write('\n');
				write.flush();
			}
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	DataParser(){
		genres=new Vector<Integer>();
		ExtractData();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DataParser();

	}

}

package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{

	ArrayList<Note> notes = new ArrayList<Note>();

	// String score = "DEFGABcd";
	// String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	float wBorder = width * 0.1f;
	float hBorder = height * 0.41f;
	int noteClicked = -1;

	public void loadScore(String score)
	{
		for(int i=0; i<score.length()-1; i++)
		{
			String test = score.substring(i,i+2);
			String local_note = score.substring(i,i+1);
			char n = local_note.charAt(0);
			char n1 = test.charAt(1);

			println(test);
			//if note duration is 2 
			if(Character.isDigit(n1))
			{
				Note s = new Note(n,2);
				notes.add(s);
				i++;
			}
			else{
				Note s = new Note(n,1);
				notes.add(s);
			}
		}// end for 
	}// end load score

	public void printScore(String score){

		for(Note n : notes)
		{
			if(n.getDuration() == 1)
			{
				System.out.println(n.getNote() + "\t" + n.getDuration() + "\t" + "Quaver " );
			}else {
				System.out.println(n.getNote() + "\t" + n.getDuration() + "\t" + "Crotchet" );
			}
			
		}
	}
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		// char c = '7'; // c holds the character 7 (55)
		// int i = c - '0'; // i holds the number 7 (55 - 48) 
		// println(i);
	}

	public void setup() 
	{
		loadScore(score);
		// printScore(score);
		
	}

	public void draw()
	{
		background(255);
		drawStraveLines();
		drawNoteText();
		drawNotes();
		if(noteClicked != -1)
		{
			Note n = notes.get(noteClicked);
		}
	}

	void drawStraveLines()
	{
		fill(0);
		// stroke(0);
		strokeWeight(2);
		
		// float gap = height * 0.005f;
		
		for(int i = 0; i < 5; i++)
		{
			float y = map(i, 1, 5,hBorder, height - hBorder);
			line(wBorder, y, width-wBorder, y);
		}


		// for(Note n : notes)
		// {	
		// 	int i = 0;
		// 	float x = map(i,0,notes.size(),wBorder, width -(2*wBorder));
		// 	text(n.getNote(), x, 220);
		// 	i++;
		// }
		
	}

	void drawNoteText()
	{

		int i = 1;
		textAlign(CENTER, CENTER);
		textSize(18);

		for(Note s: notes)
		{	
			float x = map(i,1,notes.size(),wBorder + 10, width - wBorder - 10);
			float y = map(i, 1, 5,hBorder, height - hBorder);
			text(s.getNote(),x , 120);
			i++;
		}

	}

	public void mouseClicked()
	{
		for(int i = 0; i < notes.size(); i++)
		{
			Note n = notes.get(i);
			float x = map(i,1,notes.size(),wBorder + 10, width - wBorder - 10);
			float y = map(i, 1, 5,hBorder, height - hBorder);
			if(dist(mouseX,mouseY, x, y) < 10)
			{
				noteClicked = i;
			}

		}
	}

	void drawNotes()
	{
		float circleSize = 15;
		float note_line = 21;
		int i = 0;
		fill(0);
		
		

		for(Note s: notes)
		{	
			float x = map(i,1,notes.size(),wBorder + 10, width - wBorder - 10);
			x += 50;
			//check if note is Quaver or Crotchet
			if(s.getDuration() == 1)
			{	
				switch(s.getNote())
				{
					case 'A' :
						//code block			
						circle(x, (height/2 - 11), circleSize);
						line(x + (circleSize/2), (height/2 - 11), x + (circleSize/2), (228- 22 - note_line));
						line(x + (circleSize/2), (228- 22 - note_line), (x + (circleSize/2) + 10), (228- 22 - note_line + 10 ));
						break;
						
					case 'B' :
						//code block
						circle(x, (height/2 - 22), circleSize);
						line(x + (circleSize/2), (height/2 - 22), x + (circleSize/2), (228- 33 - note_line));
						line(x + (circleSize/2), (228- 33 - note_line), (x + (circleSize/2) + 10), (228- 33 - note_line + 10 ));
						break;

					case 'c' :
						//code block
						circle(x, (height/2 - 33), circleSize);
						line(x + (circleSize/2), (height/2 - 33), x + (circleSize/2), (228- 44 - note_line));
						line(x + (circleSize/2), (228- 44 - note_line), (x + (circleSize/2) + 10), (228- 44 - note_line + 10 ));
						break;

					case 'D' :
						//code block
						circle(x, (height/2 + 33), circleSize);
						line(x + (circleSize/2), (height/2 + 33), x + (circleSize/2), (250 - note_line));
						line(x + (circleSize/2), (250 - note_line), (x + (circleSize/2) + 10), (250 - note_line + 10 ));
						break;

					case 'd' :
						//code block
						circle(x, (height/2 - 44), circleSize);
						line(x + (circleSize/2), (height/2 - 44), x + (circleSize/2), (228- 55 - note_line));
						line(x + (circleSize/2), (228- 55 - note_line), (x + (circleSize/2) + 10), (228- 55 - note_line + 10 ));

						break;

					case 'E' :
						//code block
						circle(x, (height/2 + 22), circleSize);
						line(x + (circleSize/2), (height/2 + 22), x + (circleSize/2), (239 - note_line));
						line(x + (circleSize/2), (239 - note_line), (x + (circleSize/2) + 10), (239 - note_line + 10 ));
						break;

					case 'F' :
						//code block
						circle(x, (height/2 + 11), circleSize);
						line(x + (circleSize/2), (height/2 + 11), x + (circleSize/2), (228 - note_line));
						line(x + (circleSize/2), (228 - note_line), (x + (circleSize/2) + 10), (228 - note_line + 10 ));
						break;

					case 'G' :
						//code block
						circle(x, (height/2  ), circleSize);
						line(x + (circleSize/2), (height/2  ), x + (circleSize/2), (228- 11 - note_line));
						line(x + (circleSize/2), (228- 11 - note_line), (x + (circleSize/2) + 10), (228- 11 - note_line + 10 ));
						break;

				}

				
				i++;
			}	
			else
			{
				switch(s.getNote())
				{
					case 'A' :
						//code block
						circle(x, (height/2 - 11), circleSize);
						line(x + (circleSize/2), (height/2 - 11), x + (circleSize/2), (228- 22 - note_line));						
						break;
						
					case 'B' :
						//code block
						circle(x, (height/2 - 22), circleSize);
						line(x + (circleSize/2), (height/2 - 22), x + (circleSize/2), (228- 33 - note_line));
						break;

					case 'C' :
						//code block
						circle(x, (height/2 - 33), circleSize);
						line(x + (circleSize/2), (height/2 - 33), x + (circleSize/2), (228- 44 - note_line));
						break;

					case 'D' :
						//code block
						circle(x, (height/2 + 33), circleSize);
						line(x + (circleSize/2), (height/2 + 33), x + (circleSize/2), (250 - note_line));						
						break;

					case 'E' :
						//code block
						circle(x, (height/2 + 22), circleSize);
						line(x + (circleSize/2), (height/2 + 22), x + (circleSize/2), (239 - note_line));					
						break;

					case 'F' :
						//code block
						circle(x, (height/2 + 11), circleSize);
						line(x + (circleSize/2), (height/2 + 11), x + (circleSize/2), (228 - note_line));						
						break;
					
					case 'G' :
						//code block
						circle(x, (height/2  ), circleSize);
						line(x + (circleSize/2), (height/2  ), x + (circleSize/2), (228- 11 - note_line));
						break;


				}
				i++;
			}
			
		}
	}
}

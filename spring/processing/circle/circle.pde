//Team otter_SPace
//Brian Lin, Isaac Jon, Aleksandra Koroza
// APCS2 Pd2
//HW #52: Grow & Shrink
//2018-05-22
/*
black background
upon mouseclick a circle appears (centered? Random loc?)
circle grows at fixed rate
upon second mouseclick, circle shrinks
circle is your favorite color
*/


int x = 50; // width of ellipse
int y = 50; // height of ellipse
int numClicks = 0; // number of clicks

void setup() {
  size(500, 500); // Window size
  background(0); // black background
}

void draw() { // loop by default
  color c;
  c = color(50, 55, 100); // Dark blue ellipse
  fill(c);
  if (numClicks % 2 == 1) { // grows at fixed rate with first click
    x += 1;
    y += 1;
    clear();
    background(0); // black background
    ellipse(mouseX, mouseY, x, y);
  }
  if (numClicks >= 2 && numClicks % 2 == 0) { // shrinks at fixed rate with second click
    x -= 1;
    y -= 1;
    clear();
    background(0); // black background
    ellipse(mouseX, mouseY, x, y);
    
   
  }
}

void mouseClicked() {
  numClicks += 1; // Increment by one if primary mouse button is pressed
}

Overview:

We chose to represent a single pixel in the pixel class with int fields for red green and blue.
There are methods that calculate and return the intensity, luma, and Value of the pixel.

We then created an Image interface to represent an Image. The image should be able to return its
height, width, maximum color value, and also be able to get or set individual pixels in it based
on a xy coordinate system with 0,0 in the top left. Furthermore, an image should override the
toString method so that it can return a string representation of itself that would go in a file.

We implemented the interface in the ppmImage class and represented the pixels as a 2d array of
Pixels.

Then we created a ImageProcessingModel interface which represents a model to store
all the images. The model should be able to add or get an image so that you can work on more than
one image at once.

We implemented the interface in the PPMImageProcessingModel class. The class
stores all the images as a map.

For the view, we created the TextView interface with only
one functionality, to render a message from the controller.

The TextViewImp class implements this interface and takes in an appendable to which it appends to.
This is system.Out when the user is using via console.

Finally, we created a controller interface to represent the controller
that communicates between the view and model. The controller interface is TextController
and implemented in ImageProcessingController.

The controller interface has one method, start
which starts the program and runs until the user quits or there is an error. The method
parses through user input and either runs the commands they instruct or notifies the user when
they give invalid inputs. It also handles exceptions and throws IllegalStateException
when an error happens that it can't recover from such as running out of inputs.


Assignment5 documentation:

All of the program is complete. It can do any of the required commands and also load and save files
of type ppm, png, jpeg, and bmp. It can convert between file types by loading and saving with
a different extension. Another feature is that it can take in a file by providing the filepath
via command line args it will use that file to run a script that will do operations on an image
then quit the program.

We had to change the load and save method to check if the file type was ppm
or one of the other kinds to decide what type of object to create to represent the image. This was
because ImageIO does not support ppm which we used to process the other file types.

We also removed the requirement in the interface of an image
to override the toString method and instead write to the file in the save command based on
whether it is ppm or another file type. This is because a toString for a file like png wouldn't be
feasible.

Assignment6 documentation:

All of our program is complete. It still has support for all the features and commands in
Assignment 5 documentation plus it not has a graphical view. To get the graphical view run with no
command line args. To get the old text view, run with -text and to run a script, run with -file
"name of script file". The graphical user interface also displays a histogram that shows the
red, blue, green, and intensity components of the image. You can load in an image, run commands
on it, and save it to a file. There is one other operation, downscaling, which we included only in
the GUI as extra credit work.

We only had to make one minor change, we added a new constructor to the NonPPMImage class
which takes in a width and height and makes an blank image with the specifications. we needed this
to do the extra credit command downscale.

Image Citations: all our images that we used we either created or got from Wikimedia Commons

Extra Credit: We did not have to change any of the program to accommodate this feature. We only
had to create a new command class for the downsize command and add a button to the view
for the command.

All images for downscale extra credit are in the res/downscaleExtraCredit directory.


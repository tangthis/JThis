# Contributing

Feel free to contribute to this project and help it grow.

## Author
- [Mark Goodyear](https://github.com/markgoodyear)

## Contributors
- [Phillip A Senger](https://github.com/psenger)
- [Allyson Beckers](https://github.com/allybee)
- [Nick Rameau](https://github.com/NickRameau)
- [Richard Peck](https://github.com/richpeck)

## Bugs
If you find any bugs, please add them to the issues on the GitHub page and give any examples if possible.

## Features
Please log any feature requests in the issues, or create a pull request if you have added the feature in.

## Directory Structure
Project files and folder structure.

* css - CSS for plugin and demo site
* img - For any images used by the plugin / demo
* js - Distribution files
** lib - Any libraries used
* src - The plugin source which Grunt builds from

## NodeJS and Grunt
This project uses [Node JS](http://nodejs.org/) and [Grunt](http://gruntjs.com/).

Once installed, use `npm install` in the project directory to install the required dependancies. This will create a `node_modules` folder with the dependancies. Please do not add this folder to Git.

When contributing, use the `src/jquery.scrollUp.js` file and run the Grunt tasks to complile the distribution files.

## Grunt tasks
Included Grunt tasks for scrollUp:

* grunt clean
* grunt jslint - lints the src/jquery.scrollUp.js file
* grunt conact - creates the distribution (js/jquery.scrollUp.js) file
* grunt uglify - creates the minified version in js/*

Use `grunt` to run all tasks together.


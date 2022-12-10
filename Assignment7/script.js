//===============================================================================================
// Name: Dawson Sanders
// Date: 11/28/22
// Description: This is a mario inspired side scroller game that includes mario, goombas, pipes, and fireballs
//================================================================================================

//===============================================================================================
// Sprite class 
//===============================================================================================
class Sprite {
    constructor(x, y, w, h, img) {
        this.x = x; 
        this.y = y; 
        this.w = w;
        this.h = h;
        this.image = new Image();
        this.image.src = img;
    }

    update() {}

    isPipe() { 
        return false;
    }

    isMario() {
        return false;
    }

    isGoomba() { 
        return false; 
    }

    isFireball() {
        return false;
    }

}    

//===============================================================================================
// Pipe class 
//===============================================================================================
class Pipe extends Sprite {
    constructor(x, y) {
        super(x, y, 55, 400, "imgs/pipe.png");
    }

    update() {}

    isPipe() {
        return true;
    }
}

//===============================================================================================
// Goomba class 
//===============================================================================================
class Goomba extends Sprite {
    constructor(x, y) {
        super(x, y, 37, 45, "imgs/goomba.png");
        this.horizontal_velocity = 2;
        this.vertical_velocity = 1.2;
        this.isOnFire = false;
        this.onFireCounter = 90;
    }

    update() {
        if (this.isOnFire === false) {
            this.setPreviousPositionGoomba();
            this.x += this.horizontal_velocity; 
            this.vertical_velocity += 1; 
            this.y += this.vertical_velocity;

            if(this.y > 500 - this.h) {
                this.y = 500 - this.h;
                this.vertical_velocity = 0;
            }  
        }

        if(this.isOnFire == true)
            this.onFireCounter -= 1;

        if(this.onFireCounter <= 0) {
            this.horizontal_velocity = 0;
            return false;
        }
        return true;
    }

    updateImage() {
        this.image = new Image();
        this.image.src = "imgs/goomba_fire.png";
        this.horizontal_velocity = 0;
        return true;
    }

    changeDirection() {
        this.horizontal_velocity *= -1;
    }

    setPreviousPositionGoomba() {
        this.prev_x = this.x;
        this.prev_y = this.y;
        this.prev_w = this.w;
        this.prev_h = this.h;
    }

    getOutOfPipeGoomba(pipe) {
        if (pipe.isPipe() == true) {
            // Left collision fixing
            if (this.x + this.w >= pipe.x && this.prev_x + this.w <= pipe.x)
                this.x = pipe.x - this.w;

            // Right collision fixing
            if (this.x <= pipe.x + pipe.w && this.prev_x >= pipe.x + pipe.w)
                this.x = pipe.x + pipe.w;
        }
    }
    
    isGoomba() {
        return true;
    }
}

//===============================================================================================
// Mario class 
//===============================================================================================
class Mario extends Sprite {
    constructor(x, y) {
        super(x, y, 60, 95, "imgs/mario1.png");
        this.vertical_velocity = 1.2;
        this.numFramesInAir = 0;
        this.rightFacing = true;
        this.currentImage = 0;

        this.image1 = new Image();
        this.image1.src = "imgs/mario1.png";

        this.image2 = new Image();
        this.image2.src = "imgs/mario2.png";

        this.image3 = new Image();
        this.image3.src = "imgs/mario3.png";

        this.image4 = new Image();
        this.image4.src = "imgs/mario4.png";

        this.image5 = new Image();
        this.image5.src = "imgs/mario5.png";

        this.marioImages = [];
        this.marioImages.push(this.image1);
        this.marioImages.push(this.image2);
        this.marioImages.push(this.image3);
        this.marioImages.push(this.image4);
        this.marioImages.push(this.image5);
        this.imageNum = 0;
    }

    updateImageNum() {
        this.imageNum += 1;
        if (this.imageNum >= this.marioImages.length) 
            this.imageNum = 0;
        this.image = this.marioImages[this.imageNum];
    }

    update() {
        this.vertical_velocity += 2; 
        this.y += this.vertical_velocity; 
        this.numFramesInAir++; 

        if(this.y > 501 - this.h) {
            this.vertical_velocity = 0;
            this.numFramesInAir = 0;
            this.y = 501 - this.h;
        }    
        return true;
    }

    getOutOfPipeMario(pipe) {
        if(pipe.isPipe() === true) {
            // Right collision fixing
            if(this.x + this.w >= pipe.x && this.prev_x + this.w <= pipe.x)
                this.x = pipe.x - this.w;

            // Left collision fixing
            if(this.x >= pipe.x && this.prev_x >= pipe.x + pipe.w)
                this.x = pipe.x + pipe.w;

            // Top collision fixing
            if(this.prev_y + this.prev_h <= pipe.y) {
                this.vert_velocity = 0;
                this.numFramesInAir = 0;
                this.y = pipe.y - this.h;
            }

            // Bottom collision fixing
            if(this.prev_y >= pipe.y + pipe.h) 
                this.y = pipe.y + pipe.h;
        }
    }

    setPreviousPositionMario() {
        this.prev_x = this.x;
        this.prev_y = this.y;
        this.prev_w = this.w;
        this.prev_h = this.h;
    }

    checkJump() {
        if(this.numFramesInAir < 6) {
            this.vertical_velocity = -28;
            return true;
        }
         else
            return false;
    }

    isMario() {
        return true;
    }

}

//===============================================================================================
// Fireball class 
//===============================================================================================
class Fireball extends Sprite {
    constructor(x, y) {
        super(x, y, 47, 47, "imgs/fireball.png");
        this.horizontal_velocity = 9;
        this.vertical_velocity = 2;
    }

    update() {
        this.vertical_velocity += 2; 
        this.y += this.vertical_velocity; 
        this.x += this.horizontal_velocity; 

        if(this.y > 500 - this.h) {
            this.horizontal_velocity = 9;
            this.vertical_velocity = -24;
            this.y = 500 - this.h;
        }  
        return true;
    }

    isFireball() {
        return true;
    }
}  

//===============================================================================================
// Model class 
//===============================================================================================
class Model {
    constructor() {
        this.sprites = [];
        this.mario = new Mario(100, 405, 60, 95);
        this.sprites.push(this.mario);
        this.sprites.push(new Pipe(10, 400, 55, 400));
        this.sprites.push(new Pipe(450, 250, 55, 400));
        this.sprites.push(new Pipe(800, 250, 55, 400));
        this.sprites.push(new Pipe(857, 270, 55, 400));
        this.sprites.push(new Pipe(915, 300, 55, 400));
        this.sprites.push(new Pipe(974, 330, 55, 400));
        this.sprites.push(new Pipe(1300, 330, 55, 400));
        this.sprites.push(new Goomba(750, 455, 45, 37));
        this.sprites.push(new Goomba(680, 455, 45, 37));
        this.sprites.push(new Goomba(400, 455, 45, 37));
        this.sprites.push(new Goomba(250, 455, 45, 37));
        this.sprites.push(new Goomba(1100, 455, 45, 37));
    }

    addFireball() {
        this.sprites.push(new Fireball(this.mario.x, this.mario.y + this.mario.h / 2)); 
    }

    isThereACollision(a, b) {
        // If sprite is not colliding 
        if(a.x + a.w < b.x) return false;
        if(a.x > b.x + b.w) return false;
        if(a.y + a.h < b.y) return false;
        if(a.y > b.y + b.h) return false;

        // If sprite is NOT not colliding ---> meaning he is colliding
        return true;
    }

    update() {
        for(let i = 0; i < this.sprites.length; i++) {

            // Checking if all sprite update methods return false, if so remove sprite
            if (this.sprites[i].update() === false) {
                this.sprites.splice(i, 1);
                continue;
            }

            // Calling update method on all sprites 
            this.sprites[i].update();

            // Checking if there is a collision between sprites
            for (let j = 0; j < this.sprites.length; j++) {

                // Checking if there is a collision between mario and pipes
                if (this.isThereACollision(this.sprites[i], this.sprites[j])) {
                    if (this.sprites[i].isMario() && this.sprites[j].isPipe()) {
                        this.sprites[i].getOutOfPipeMario(this.sprites[j]);
                    }

                     // Checking if there is a collision between goombas and pipes
                    if (this.sprites[i].isGoomba() && this.sprites[j].isPipe()) {
                        this.sprites[i].getOutOfPipeGoomba(this.sprites[j]);
                        this.sprites[i].changeDirection();
                    }
                    
                    // Checking if there is a collision between goombas and fireballs
                    if (this.sprites[i].isGoomba() && this.sprites[j].isFireball()) {
                        this.sprites[i].isOnFire = true;
                        this.sprites[i].updateImage();
                    }
                }
            }
        }        
    }
}
    
//===============================================================================================
// View class 
//=============================================================================================== 
class View {
    constructor(model) {
        this.model = model;
        this.canvas = document.getElementById("myCanvas");
        this.scrollPos = 0;
    }

    update() {
        this.scrollPos = this.model.mario.x - 100;
        let ctx = this.canvas.getContext("2d");
        ctx.clearRect(0, 0, 1000, 500);

        // Looping through array of sprites to draw them 
        for(let i = 0; i < this.model.sprites.length; i++) {
            let sprite = this.model.sprites[i];
                ctx.drawImage(sprite.image, sprite.x - this.scrollPos, sprite.y, sprite.w, sprite.h);
        }
    }
}

//===============================================================================================
// Controller class 
//===============================================================================================
class Controller {
    constructor(model, view) {
        this.model = model;
        this.view = view;
        this.key_right = false;
        this.key_left = false;
        this.key_up = false;
        this.key_down = false;
        this.space_bar = false;
        this.control_key = false;
        this.f_key = false;
        let self = this;

        document.addEventListener('keydown', function(event) { 
            self.keyDown(event); 
        }, false);

        document.addEventListener('keyup', function(event) { 
            self.keyUp(event); 
        }, false);
        
    }

    // Keydown event is fired when any key is PRESSED
    keyDown(event) {
        if(event.keyCode == 39) this.key_right = true;
        else if(event.keyCode == 37) this.key_left = true;
        else if(event.keyCode == 38) this.key_up = true;
        else if(event.keyCode == 40) this.key_down = true;
        else if(event.keyCode == 32) this.space_bar = true;
        else if(event.keyCode == 17) this.control_key = true;
        else if(event.keyCode == 70) this.f_key = true;
    }

    // Keyup event is fired when a key any key is RELEASED
    keyUp(event) {
        if(event.keyCode == 39) this.key_right = false;
        else if(event.keyCode == 37) this.key_left = false;
        else if(event.keyCode == 38) this.key_up = false;
        else if(event.keyCode == 40) this.key_down = false;
        else if(event.keyCode == 32) this.space_bar = false;
        else if(event.keyCode == 17) this.control_key = false;
        else if(event.keyCode == 70) this.f_key = false;
    }

    update() {
        this.model.mario.setPreviousPositionMario();

        // Statement to control the right arrow key and updates mario
        if(this.key_right) {
            this.model.mario.rightFacing = true;
            this.model.mario.x += 10;
            this.model.mario.updateImageNum();
        }

        // Statement to control the left arrow key and updates mario
        if(this.key_left) {
            this.model.mario.rightFacing = false;
            this.model.mario.x -= 10; 
            this.model.mario.updateImageNum();
        }  

        // Statement to make mario jump by the spacebar
        if(this.space_bar) 
            this.model.mario.checkJump();

        // Statement to make mario throw fireball with control key
        if(this.control_key) {
            this.model.addFireball();
        }   

        // Statement to make mario throw fireball with f key
        if(this.f_key) {
            this.model.addFireball();
        }   
    }
}

//===============================================================================================
// Game class 
//===============================================================================================
class Game {
    constructor() {
        this.model = new Model();
        this.controller = new Controller(this.model, this.view);
        this.view = new View(this.model);
    }
    
    onTimer() {
        this.controller.update();
        this.model.update();
        this.view.update();
    }
}

let game = new Game();
let timer = setInterval(function() { 
    game.onTimer(); 
}, 40);
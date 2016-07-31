﻿package collision {		import flash.events.*;	import flash.display.MovieClip;		public class CollidableObject extends BoxCollider{		protected var coverImg:ObjectCovers = new ObjectCovers();		private var npc:NPCData;		private var originalX:int;		private var isPlayingGate:Boolean;		public function CollidableObject(coverName:String, xPos:int, yPos:int, w:int, h:int, hBW:int = -1, hBH:int = -1) {						super(xPos, yPos, w, h);						coverImg.gotoAndStop(coverName);						originalX = xPos;												//Sets hit box			hitBox.width = coverImg.width;			hitBox.height = 40;			hitBox.y = coverImg.height - 40;						//Adjusts hitBox dimensions			if(hBW >= 0){				hitBox.width = hBW;			}			if(hBH >= 0){				hitBox.height = hBH;				hitBox.y = coverImg.height - hitBox.height;			}						hitBox.width = coverImg.width;						//Adds cover image			this.addChild(coverImg);						addEventListener(Event.ADDED, added);			addEventListener(Event.REMOVED, removed);		}		public function added(event:Event):void{						super._root = MovieClip(root);						//Adjusts layering			addEventListener(Event.ENTER_FRAME, adjustLayer);		}				public function removed(event:Event):void{			removeEventListener(Event.ADDED, added);			removeEventListener(Event.REMOVED, removed);			removeEventListener(Event.ENTER_FRAME, adjustLayer);		}		//Adjust the layer of the NPC with the player		public function adjustLayer(event:Event):void{			if(this.y + this.height > _root.player.y + _root.player.height){				parent.setChildIndex(this, parent.numChildren - 1);			}			else{				parent.setChildIndex(this, 0);			}		}	}	}
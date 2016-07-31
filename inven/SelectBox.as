﻿package inven{		import flash.display.MovieClip;	import flash.events.*;	import flash.text.*;		public class SelectBox extends MovieClip{		var _root:MovieClip;		private var textBoxList:Array = new Array();		public var strArray:Array;				private var pointer:InvPointer = new InvPointer();		private var pointerIndex:int = 0;				private var format:TextFormat = new TextFormat();		public var freezePointer:Boolean = false;		public function SelectBox(sA:Array){						strArray = sA;						format.size = 20;			format.font = "_sans";						setUpPointer();						this.addEventListener(Event.ADDED, startClass);			this.addEventListener(Event.REMOVED, endClass);		}				//Connects to main program		public function startClass(event:Event){			_root = MovieClip(root);						this.addEventListener(Event.ENTER_FRAME, updateInv);		}				public function endClass(event:Event){			resetPointer();						this.removeEventListener(Event.ENTER_FRAME, updateInv);		}						public function setUpTextBoxes():void{						var maxWidth:int = 0;						for(var i:int = 0; i < strArray.length; i++){				//Add item name text box				textBoxList[i] = new TextField();								textBoxList[i].setTextFormat(format);				textBoxList[i].x = 50;				textBoxList[i].y = 30 + 1.5 * (int)(format.size) * i;								textBoxList[i].width = (int)(format.size) * strArray[i].length;								placeLayer.addChild(textBoxList[i]);								//Get max width				if(textBoxList[i].width > maxWidth){					maxWidth = textBoxList[i].width;				}							}						//Sets box's height and width			boxBacking.width = this.width - 20;			boxBacking.height = textBoxList[strArray.length - 1].y + textBoxList[strArray.length - 1].height - textBoxList[0].y;					}				public function setUpPointer():void{			pointer.x = 10;			pointer.y = 30;						placeLayer.addChild(pointer);		}				//Updates the text box in inventory		public function updateInv(event:Event):void{			//Update text fields			for(var i:int = 0; i < strArray.length; i++){				//Update name				textBoxList[i].text = strArray[i];				textBoxList[i].selectable = false;				textBoxList[i].setTextFormat(format);			}									//Update pointer if not frozen			if(!freezePointer){				if(_root.upDown && _root.pointerCoolDown == 0 && pointerIndex > 0){					_root.pointerCoolDown = 5;										pointerIndex--;					pointer.y = textBoxList[pointerIndex].y;				}				else if(_root.downDown && _root.pointerCoolDown == 0 && pointerIndex < strArray.length - 1){					_root.pointerCoolDown = 5;										pointerIndex++;					pointer.y = textBoxList[pointerIndex].y;				}			}		}				//Reset pointer		public function resetPointer():void{			pointer.x = 10;			pointer.y = 30;			pointerIndex = 0;		}				public function getPointerIndex():int{			return pointerIndex;		}				public function setPointerIndex(n:int):void{			pointerIndex = n;			pointer.y = textBoxList[n].y;		}				//Reset items		public function resetItems(){						for(var i:int = 0; i < textBoxList.length; i++){								placeLayer.removeChild(textBoxList[i]);			}		}				//Get text format		public function getFormat():TextFormat{			return format;		}			}	}
﻿package  {		import flash.display.MovieClip;	import flash.events.*;	import flash.text.*;		public class SelectBox extends MovieClip{		var _root:MovieClip;		private var textBoxList:Array = new Array();		private var strArray:Array;				private var pointer:InvPointer = new InvPointer();		private var pointerIndex:int = 0;				private var format:TextFormat = new TextFormat();		public function SelectBox(sA:Array){						strArray = sA;						format.size = 20;			format.font = "_sans";						setUpTextBoxes();			setUpPointer();						this.addEventListener(Event.ADDED, startClass);			this.addEventListener(Event.REMOVED, endClass);		}				//Connects to main program		public function startClass(event:Event){			_root = MovieClip(root);						this.addEventListener(Event.ENTER_FRAME, updateInv);		}				public function endClass(event:Event){			resetPointer();						this.removeEventListener(Event.ENTER_FRAME, updateInv);		}						public function setUpTextBoxes():void{			for(var i:int = 0; i < strArray.length; i++){				//Add item name text box				textBoxList[i] = new TextField();								textBoxList[i].setTextFormat(format);				textBoxList[i].x = 50;				textBoxList[i].y = 30 + 1.5 * (int)(format.size) * i;				textBoxList[i].width = 300;								this.addChild(textBoxList[i]);							}		}				public function setUpPointer():void{			pointer.x = 10;			pointer.y = 30;						addChild(pointer);		}				//Updates the text box in inventory		public function updateInv(event:Event):void{			//Update text fields			for(var i:int = 0; i < strArray.length; i++){				//Update name				textBoxList[i].text = strArray[i];				textBoxList[i].setTextFormat(format);			}									//Update pointer			if(_root.upDown && _root.pointerCoolDown == 0 && pointerIndex > 0){				_root.pointerCoolDown = 5;								pointerIndex--;				pointer.y = textBoxList[pointerIndex].y;			}			else if(_root.downDown && _root.pointerCoolDown == 0 && pointerIndex < strArray.length - 1){				_root.pointerCoolDown = 5;								pointerIndex++;				pointer.y = textBoxList[pointerIndex].y;			}		}				//Reset pointer		public function resetPointer():void{			pointer.x = 10;			pointer.y = 30;			pointerIndex = 0;		}				public function getPointerIndex():int{			return pointerIndex;		}	}	}
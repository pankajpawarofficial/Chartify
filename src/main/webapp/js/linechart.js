var xhr = new XMLHttpRequest();
var chart;

var globalYear=null;
var globalQuarter=null;

var slNo=["Sl No"];
var dataPoints=["DataPoints"];
var uCL1=["UCL1"];
var lCL1=["LCL1"];
var uCL2=["UCL2"];
var lCL2=["LCL2"];
var uCL3=["UCL3"];
var lCL3=["LCL3"];
var mean=["Mean"];
var uSL=["USL"];
var lSL=["LSL"];
var outlier=["Outliers"];

var sslNo=["Sl No"];
var sdataPoints=["DataPoints"];
var suCL1=["UCL1"];
var slCL1=["LCL1"];
var suCL2=["UCL2"];
var slCL2=["LCL2"];
var suCL3=["UCL3"];
var slCL3=["LCL3"];
var smean=["Mean"];
var suSL=["USL"];
var slSL=["LSL"];
var soutlier=["Outliers"];

var arrayOfObjects;

function selectYear(option){
	console.log(String(option));
	document.getElementById("year").textContent=String(option);
	globalYear=String(option);
	if(String(option)==='Year'){
		globalQuarter='Quarter';
		document.getElementById("quarter").textContent="Quarter";
		document.getElementById("quarterbutton").classList.add("disabled")
		
	}
	else{
		document.getElementById("quarterbutton").classList.remove("disabled")
		for(var i=1;i<=arrayOfObjects.length;i++){
			
			sslNo[i]=arrayOfObjects[i-1].slNo;
			sdataPoints[i]=arrayOfObjects[i-1].dataPoint;
			suCL1[i]=arrayOfObjects[i-1].uCL1;
			slCL1[i]=arrayOfObjects[i-1].lCL1;
			suCL2[i]=arrayOfObjects[i-1].uCL2;
			slCL2[i]=arrayOfObjects[i-1].lCL2;
			suCL3[i]=arrayOfObjects[i-1].uCL3;
			slCL3[i]=arrayOfObjects[i-1].lCL3;
			smean[i]=arrayOfObjects[i-1].mean;
			suSL[i]=arrayOfObjects[i-1].uSL;
			slSL[i]=arrayOfObjects[i-1].lSL;
			if(arrayOfObjects[i-1].outlier==true)
				soutlier[i]=arrayOfObjects[i-1].dataPoint;
			else
				soutlier[i]=null;
		}
	}
		
}

function selectQuarter(option){
	console.log(String(option));
	document.getElementById("quarter").textContent=String(option);
	globalQuarter=String(option);
}


xhr.onreadystatechange = function() {
if (xhr.readyState == 4 && xhr.status == 200) {
		console.log(xhr.responseText);
		arrayOfObjects=JSON.parse(xhr.responseText);
		
		console.log(arrayOfObjects);
		
		
		
		
		for(var i=1;i<=arrayOfObjects.length;i++){
			slNo[i]=arrayOfObjects[i-1].slNo;
			dataPoints[i]=arrayOfObjects[i-1].dataPoint;
			uCL1[i]=arrayOfObjects[i-1].uCL1;
			lCL1[i]=arrayOfObjects[i-1].lCL1;
			uCL2[i]=arrayOfObjects[i-1].uCL2;
			lCL2[i]=arrayOfObjects[i-1].lCL2;
			uCL3[i]=arrayOfObjects[i-1].uCL3;
			lCL3[i]=arrayOfObjects[i-1].lCL3;
			mean[i]=arrayOfObjects[i-1].mean;
			uSL[i]=arrayOfObjects[i-1].uSL;
			lSL[i]=arrayOfObjects[i-1].lSL;
			if(arrayOfObjects[i-1].outlier==true)
				outlier[i]=arrayOfObjects[i-1].dataPoint;
			else
				outlier[i]=null;
		}
		
		console.log(outlier);
		
		
		chart = c3.generate({
			data: {
		        x: slNo[0],
		        columns: [slNo,dataPoints,uCL1,lCL1,uCL2,lCL2,uCL3,lCL3,mean,outlier],
		        types:{
		        	Outliers:'scatter'
		        	},
		        colors: {
		            Outliers: '#ff0000',
		            }
		   
		    },
		    axis: {
		        x: {
		            label: 'Sl No'
		        },
		        y: {
		            label: 'DataPoints'
		        }
		    },
		    point: {
		
		        show: true,
		        focus: {
		            expand: {
		              enabled: true,
		              r: 1
		            }
		          }
		        
		    },
		    zoom: {
		        enabled: true,
		        rescale: true
		        }
		});
	}
}



xhr.open('GET', 'ChartDataProvider', true);
xhr.send(null);




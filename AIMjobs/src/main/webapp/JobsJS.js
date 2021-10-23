createJobSlides();

var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function requestData(callback){
	var jobs_list = new Array();
	var jobName = "";
	var requirments= "";
	var user = "";
	
    $.ajax({
			url: "Fetch.jsp",
			type: 'GET',
			data: {JobName: jobName, Requirments: requirments, User: user},
			success: function(data) {
				jobs_list = data;
				callback(jobs_list);
				return false;
			},
			dataType:"json",
			error: function () {}
	});
}

function createJobSlides(){
	
	requestData(function(jobs_list){
		
		console.log(jobs_list);
		
		var length = jobs_list.length;
		
		for(var i=0; i<length; i++){
			var job = jobs_list[i];
			var title = job[0];
			
			var div = document.createElement("div");
			div.className = "mySlides fade";
			div.id = title;
	
			var numLabel = document.createElement("div");
			numLabel.className = "numbertext"
			numLabel.innerHTML = i.toString() + " / " + length.toString();
			div.appendChild(numLabel);
			
			var jobDiv = document.createElement("div");
			jobDiv.id = "rcorners1"
			jobDiv.innerHTML = title;
			
			for(var j=1; j<job.length; j++){
				jobDiv.innerHTML += "<li>" + job[j] + "</li>";
			}
			
			div.appendChild(jobDiv);
			document.getElementsByClassName("slideshow-container")[0].appendChild(div);
			
		}
	});
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
}

createJobJ = null;

 $(function() { 
		
        function createJobJ(){ 
			var returnName;
        	$.ajax({
				url: "fetch.jsp",
				type: 'GET',
				data: {JobName: jobName},
				success: function(data) {
					var returnName = data;
					callback(returnName);
					return false;
				}
			});
			return returnName;
        }  
        createJob = createJobJ;
 }) 

<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


    <!-- Carousel
    ================================================== -->
    
    
    <div id="myCarousel" class="carousel slide carousel-fade" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
        
      <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image" src="<c:url value="/resources/images/pexels-photo.jpg" />" alt="First slide"/>
           <div class="container">
            <div class="carousel-caption" style="top:70px;">
              <h2>"Where words leave off, music begins."</h2>
              <p><a class="btn btn-lg btn-success" href="#" role="button">Get In Touch</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide home-image" src="<c:url value="/resources/images/pexels-photo-89909.jpeg" />" alt="Second slide"/>
          <div class="container">
            <div class="carousel-caption">
              <h1>Facts You Should Know About Music.</h1>
              <p>Music brings joy, to all our hearts. It's one of those emotional arts.</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide home-image" src="<c:url value="/resources/images/pexels-photo-144429.jpeg" />" alt="Third slide"/>
          <div class="container">
            <div class="carousel-caption">
              <h1>It's A Jam Affair</h1>
              <p>Through ups and downs, Somehow I manage to Survive in Life</p>
            </div>
          </div>
        </div>
      </div>
      </div> 
      <!-- <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>-->
     
    </div>
    <!-- /.carousel -->


    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->
    <br/><br/><br/>

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
      
        <div class="col-lg-4">
        <a class="btn btn-default" role="button" href="<c:url value="product/productList?searchCondition=Instrument"/>">
          <img class="img-circle" src="/resources/images/Instrument.png" alt="Instrument Image" width="200" height="160"/>
        </a>
          <h2>Instrument</h2>
          <p>It's easy to play any musical instrument, all you have to do is touch the right key at the right time and the instrument will play itself</p>
     </div><!-- /.col-lg-4 -->
        
        <div class="col-lg-4">
        <a class="btn btn-default" href="<c:url value="product/productList?searchCondition=Record"/>" role="button">
          <img class="img-circle" src="/resources/images/Record.png" alt="Record Image" width="200" height="140"/>
         </a>
          <h2>Discography</h2>
          <p>Don't forget the songs that made you cry and the songs that saved your life. Yes, you are older now and much clever but they were the only ones who stood by you</p>
        </div><!-- /.col-lg-4 -->
        
        <div class="col-lg-4">
        <a class="btn btn-default" role="button" href="<c:url value="product/productList?searchCondition=Accessory"/>">
          <img class="img-circle" src="/resources/images/Accessory.png" alt="Accessory Image" width="200" height="140">
         </a> 
          <h2>Accessory</h2>
          <p>You have to take a deep breath and allow the music to flow through you</p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->

    </div>

    <%@include file="/WEB-INF/views/templates/footer.jsp" %>
      
     
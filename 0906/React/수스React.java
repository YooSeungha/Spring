< 리액트 (React) >

#Part1: 상위컴포넌트와 하위컴포넌트간의 데이터 교환 

[1] why? React
	(1) Output 
		- Rich: "화려한"
		- Reuse: "재사용"
		- Modularity: "모듈화" ( == Component 화 == 레고블럭 화 ) 
		- AutoUpdate: "자동갱신"

	(2) Input 
		- 학습에 대한 에너지 
		- 버젼이 올라감에 따라 셋팅법이 바뀜 

[2] 환경설정 
	(1) Node.js 설치
		1) 다운로드 ( node-v16.17.0-x64.msi )
			- https://nodejs.org/ko/download/

		2) 설치 
			- Actomatically ~ : 체크하지 X 
			- Chocolatey 설치 : 엔터!
			
		3) node 와 npm 설치/버젼 확인 
			#> node -v 
			#> npm -v 

		4) create-react-app 으로 리액트앱 생성 / 서버실행 
			<1> 방법1 ( npx )
				C:\SOO\React>npx -v //5.2+ 확인 
				C:\SOO\React>npx create-react-app t-app1 //생성
				//C:\SOO\React>npm uninstall -g create-react-app //생성안되면..삭제 후 다시생성
				C:\SOO\React>cd t-app1
				C:\SOO\React\t-app1>npm start

			<2> 방법2 ( npm )
				C:\SOO\React>npm init react-app t-app2
				C:\SOO\React>cd t-app2
				C:\SOO\React\t-app2>npm start

			<3> 방법3 ( yarn )
				C:\SOO\React>npm install -g yarn //얀 설치  
				C:\SOO\React>yarn -v //0.25+ 확인 
				C:\SOO\React>yarn create react-app t-app3 //주의: - 삭제 
				C:\SOO\React>cd t-app3
				C:\SOO\React\t-app3>yarn start


		5) React 서버 종료 
			Ctrl + C 


	(2) VSCode 환경에서 서버 실행 
		1) VSCode로 t-app3 폴더 열기 

		2) React 서버 실행 
		    - VSCode 새 터미널 ( Command ~ 선택 )

		    <1> 방법1
				C:\SOO\React\t-app3>npm start
				
		    <2> 방법2
			    C:\SOO\React\t-app3>yarn start //안되면.. VSCode 껐다가 켜요

		3) React 서버 종료 
            Ctrl + C

[3] Hello.. React 출력
	(1) src/App.js 
		//import logo from './logo.svg';
		import './App.css';

		function App() {
		  return (
			<div className="App">
			  <h1>안녕.. 리액트^^</h1>
			</div>
		  );
		}
	    .. 

	(2) CSS 수정 
		1) src/index.css
			body {
			  background-color: yellowgreen;
			}
			
		2) src/App.css
			.App {
			  text-align: right;
			}

[4] Publishing 
	(1) 크롬 F12 -> 새로고침 아이콘 -> 오른쪽 마우스 -> 캐시비우기 및 강력새로고침
	(2) Network탭 -> 897 KB 전송됨 / 2.2 MB 리소스   
	(3) build 생성 
		C:\SOO\React\t-app3>npm run build //build 디렉토리 생성 확인
	(4) 서버설치 
		#>npm install -g server 
	(5) 서버실행
		#>npx serve -s build 
	(6) 크롬에서 확인 
		- http://localhost:3000 
		- Network탭 -> 531 kB 전송됨 / 681 kB 리소스

[5] Component 제작 
	(1) VSCode 에서 앱을 생성 
		1) 생성 
			C:\SOO\React>yarn create react-app react-app

		2) 파일 -> 폴더열기 
			C:\SOO\React\react-app
		
		3) 서버 실행 
			C:\SOO\React\react-app>yarn start

	(2) public/origin.html 드레그앤드랍
		<html>
			<head>
				<meta charset="utf-8">
				<title>react-app</title>
			</head>
			<body>
				<header>
					<h1>홈</h1>
					리액트 인덱스^^
				</header>

				<nav>
					<ul>
					   <li><a href="1.html">자바</a></li> 
					   <li><a href="2.html">파이썬</a></li>
					   <li><a href="3.html">오라클</a></li>
					</ul>
				</nav>

				<article>
					<h3>자바</h3>
					자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어! 
				</article>
			</body>
		</html>
	
	(3) 요청
		http://localhost:3000/origin.html
	
	(4) App.js 
		function App() {
		  return (
			<div className="App">
			  <header>
				<h1>홈</h1>
				리액트 인덱스^^
			  </header>

			  <nav>
				<ul>
				  <li><a href="1.html">자바</a></li> 
				  <li><a href="2.html">파이썬</a></li>
				  <li><a href="3.html">오라클</a></li>
				</ul>
			  </nav>

			  <article>
				<h3>자바</h3>
				자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어! 
			  </article>

			</div>
		  );
		}
		
	(5) App.css
		.App {
		  text-align: left;
		}

		#요청: http://localhost:3000/

	(6) 컴포넌트 분리1 ( App.js : class ) 
		class Subject extends Component {
		  render(){
			return(
			  <header>
				<h1>홈</h1>
				리액트 인덱스^^
					</header>
			);
		  }
		}
		class NavC extends Component {
		  render(){
			return(
			  <nav>
				<ul>
				  <li><a href="1.html">자바</a></li> 
				  <li><a href="2.html">파이썬</a></li>
				  <li><a href="3.html">오라클</a></li>
				</ul>
			  </nav> 
			);
		  }
		}
		class Content extends Component {
		  render(){
			return(
			  <article>
				<h3>자바</h3>
				자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어! 
			  </article>  
			);
		  }
		}
		function App() {
		  return (
			<div className="App">
			  <Subject/>
			  <NavC/>
			  <Content/>
			</div>
		  );
		}
		export default App;

	(7) 컴포넌트 분리2 ( App.js : props )
		class Subject extends Component {
		  render(){
			return(
			  <header>
				<h1>{this.props.title}</h1>
				{this.props.sub}
					</header>
			);
		  }
		}
		class NavC extends Component {
		  ...
		}
		class Content extends Component {
		  render(){
			return(
			  <article>
				<h3>{this.props.title}</h3>
				{this.props.desc} 
			  </article>  
			);
		  }
		}
		function App() {
		  return (
			<div className="App">
			  <Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
			  <NavC/>
			  <Content title="자바!" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어!!"/>
			</div>
		  );
		}
		export default App;

	(8) 컴포넌트 분리3 ( 'src/components/각 파일'로 분리 )
		1) Subject.js
			import { Component } from 'react';
			class Subject extends Component {
				render(){
					return(
					<header>
						<h1>{this.props.title}</h1>
						{this.props.sub}
							</header>
					);
				}
			}
			export default Subject;
			
		2) NavC.js
			import { Component } from "react";
			class NavC extends Component {
				render(){
					return(
					<nav>
						<ul>
						<li><a href="1.html">자바</a></li> 
						<li><a href="2.html">파이썬</a></li>
						<li><a href="3.html">오라클</a></li>
						</ul>
					</nav> 
					);
				}
			}
			export default NavC;

		3) Content.js
			import { Component } from 'react';
			class Content extends Component {
				render(){
					return(
					<article>
						<h3>{this.props.title}</h3>
						{this.props.desc} 
					</article>  
					);
				}
			}
			export default Content;

		4) src/App.js
			import './App.css';
			import Subject from './components/Subject';
			import NavC from './components/NavC';
			import Content from './components/Content';

			function App() {
			  return (
				<div className="App">
				  <Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
				  <NavC/>
				  <Content title="자바!" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어!!"/>
				</div>
			  );
			}
			export default App;

[6] 크롬 디버깅 확장프로그램 설치
	(1) 앱스토어 검색 
		'React Developer Tools'
	(2) 크롬 재시작
	(3) Components 탭 

[7] props 속성값에 'state' 적용
	(1) App.js '함수' 형태의 Component 를 '클래스' 형태로 변경 
		/*
		function App() {
		  return (
			<div className="App">
			  <Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
			  <NavC/>
			  <Content title="자바!" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어!!"/>
			</div>
		  );
		}*/
		class App extends Component{
		  render(){
			return(
			  <div className="App">
				<Subject title="수스 홈" sub="수스 리액트 홈페이지"/>
				<NavC/>
				<Content title="자바!" desc="자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어!!"/>
			  </div>
			);
		  }
		}
		export default App;

	(2) state 적용 
		1) 상위컴포넌트( App.js )에 정의 
			class App extends Component{
			  constructor(props){
				super(props);
				this.state = {
				  subject: {title:"수스 Home", sub:"수스 리액트 홈페이지"}, 
				  navc: [
					{id:1, title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어^^"}, 
					{id:2, title:"파이썬", desc:"데이터 과학에 최적화 된 언어"}, 
							{id:3, title:"오라클", desc:"가장 안정적인 대용량 시스템구축을 위한 DBMS"}  
				  ], 
				  content: {title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어^^"}
				}
			  }
			  render(){
				return(
				  <div className="App">
					<Subject title={this.state.subject.title} sub={this.state.subject.sub}/>
					<NavC data={this.state.navc}/>
					<Content title={this.state.content.title} desc={this.state.content.desc}/>
				  </div>
				);
			  }
			}
			export default App;
			
		2) 하위컴포넌트( NavC.js )에 적용 
			import { Component } from "react";
			class NavC extends Component {
				render(){
					var lists = [];
					var data = this.props.data;
					for(var i=0; i<data.length; i++){
						lists.push(<li key={data[i].id}><a href={"/content/"+data[i].id}>{data[i].title}</a></li>);
					}
					return(
						<nav>
							<ul>
								{lists}
							</ul>
						</nav> 
					);
				}
			}
			export default NavC;

[8] Event 
	(1) 상위컴포넌트( App.js )에서 직접 이벤트 처리
		... 
		render(){
			return(
			  <div className="App">
				{/* <Subject title={this.state.subject.title} sub={this.state.subject.sub}/> */}
				<header>
					<h1><a href="/" onClick={function(e){
						console.log("e", e); //이벤트 객체 확인 
						e.preventDefault(); //<a>가 가진 고유한 기능(이동/페이지갱신)을 막음 
						//debugger;
					}}>{this.state.subject.title}</a></h1>
					{this.state.subject.sub}
				</header>
				<NavC data={this.state.navc}/>
				<Content title={this.state.content.title} desc={this.state.content.desc}/>
			  </div>
			);
		  }
		  ...

	(2) "수스 Home" 링크를 click할때 <Content>내용이 갱신 
		class App extends Component{
		  constructor(props){
			super(props);
			this.state = {
			  mode: "read", 
			  welcome: {title:"환영", desc:"어서와~ 리액트홈!"}, 
			  subject: {title:"수스 Home", sub:"수스 리액트 홈페이지"}, 
			  navc: [
				{id:1, title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어^^"}, 
				{id:2, title:"파이썬", desc:"데이터 과학에 최적화 된 언어"}, 
						{id:3, title:"오라클", desc:"가장 안정적인 대용량 시스템구축을 위한 DBMS"}  
			  ], 
			  content: {title:"자바", desc:"자바는 엔터프라이즈 솔루션 구축에 최적화 된 언어^^"}
			}
		  }
		  render(){
			var _title, _desc;
			if(this.state.mode === "welcome"){
			  _title = this.state.welcome.title;
			  _desc = this.state.welcome.desc;
			}else if(this.state.mode === "read"){
			  _title = this.state.navc[0].title;
			  _desc = this.state.navc[0].desc;
			}
			return(
			  <div className="App">
				{/* <Subject title={this.state.subject.title} sub={this.state.subject.sub}/> */}
				<header>
					<h1><a href="/" onClick={function(e){
						console.log("e", e); //이벤트 객체 확인 
						e.preventDefault(); //<a>가 가진 고유한 기능(이동/페이지갱신)을 막음 
						//debugger;

						//this.state.mode = 'welcome'; //주의: 안됨!
						this.setState(
						  {mode: "welcome"}
						);
					}.bind(this)}>{this.state.subject.title}</a></h1>
					{this.state.subject.sub}
				</header>
				<NavC data={this.state.navc}/>
				<Content title={_title} desc={_desc}/>
			  </div>
			);
		  }
		}
	
		#참고1) bind()에 대하여.. ( 크롬의 Console탭에서 )
			var obj = {name:"SoosReact"}
			function bindTest(){
				console.log(this.name);
			}
			bindTest();
			//결과: undefined

			var bindTest2 = bindTest.bind(obj);
			bindTest2();
			//결과: SoosReact

		#참고2) 크롬의 Console탭에서 js작성시 줄바꿈 
			Shift + Enter

	(3) 하위 컴포넌트에서( Subject.js )에서 이벤트 처리 
		1) App.js에 이벤트 정의 
			{/* <header>
				<h1><a href="/" onClick={function(e){
					console.log("e", e); //이벤트 객체 확인 
					e.preventDefault(); //<a>가 가진 고유한 기능(이동/페이지갱신)을 막음 
					//debugger;

					//this.state.mode = 'welcome'; //주의: 안됨!
					this.setState(
					  {mode: "welcome"}
					);
				}.bind(this)}>{this.state.subject.title}</a></h1>
				{this.state.subject.sub}
			</header> */}
			<Subject 
			  title={this.state.subject.title} 
			  sub={this.state.subject.sub} 
			  onChangePage={function(){
				this.setState(
				  {mode: "welcome"}
				);
			  }.bind(this)}/>

		2) Subject.js 에서 이벤트 호출 
			import { Component } from 'react';
			class Subject extends Component {
				render(){
					console.log("#Subject render()");
					return(
					<header>
						<h1>
							<a href="/" onClick={function(e){
								e.preventDefault();
								this.props.onChangePage();
							}.bind(this)}>
								{this.props.title}
							</a>
						</h1>
						{this.props.sub}
					</header>
					);
				}
			}
			export default Subject;

	(4) 하위 컴포넌트( NavC.js )에서 이벤트 처리 
		1) App.js에 이벤트 정의 
			<NavC 
			  data={this.state.navc}
			  onChangePage={function(){
				this.setState(
				  {mode: "read"}
				);
			  }.bind(this)}/>

		2) NavC.js 에서 이벤트 호출 
			<li key={data[i].id}>
                <a 
                    href={"/content/"+data[i].id}
                    onClick={function(e){
                        e.preventDefault();   
                        this.props.onChangePage();  
                    }.bind(this)}>{data[i].title}
                </a>
            </li>

	(5) 상위컴포넌트( App.js)에서 selected_navc_id 속성 추가 
		class App extends Component{
		  constructor(props){
			super(props);
			this.state = {
			  ...
			  selected_navc_id: 2, 
			  ...
			}
		  }
		  render(){
			...
			}else if(this.state.mode === "read"){
			  //_title = this.state.navc[0].title;
			  //_desc = this.state.navc[0].desc;

			  for(var i=0; i<this.state.navc.length; i++){
				var data = this.state.navc[i];
				if(data.id === this.state.selected_navc_id){
				  _title = data.title;
				  _desc = data.desc;
				  break;
				}
			  }
			}
			...
		  }
		}

	(6) 하위컴포넌트( NavC.js )에서 파라미터(id)를 넘김
		1) id값을 로그로 출력 
			<li key={data[i].id}>
                <a 
                    href={"/content/"+data[i].id}
                    data-id={data[i].id} //먼저 추가
                    onClick={function(e){
                        console.log("#NavC e", e);
                        console.log("#NavC e.target.dataset.id", e.target.dataset.id);
                        e.preventDefault();   
                        debugger;
                        //this.props.onChangePage();  
                    }.bind(this)}>{data[i].title}
                </a>
            </li>

		2) 파라미터로 넘기기 
			<1> 방법1 ( 'data-XXX=' 속성 이용 )
				<li key={data[i].id}>
					<a 
						href={"/content/"+data[i].id}
						data-id={data[i].id} //먼저 추가
						onClick={function(e){
							//console.log("#NavC e", e);
							//console.log("#NavC e.target.dataset.id", e.target.dataset.id);
							e.preventDefault();   
							//debugger;
							this.props.onChangePage(e.target.dataset.id);  
						}.bind(this)}>{data[i].title}
					</a>
				</li>

			<2> 방법2 ( 'bind(파라미터)' 이용 )
				<li key={data[i].id}>
					<a 
						href={"/content/"+data[i].id}
						onClick={function(id, e){
							console.log("#NavC id", id);
							e.preventDefault();   
							//debugger;
							this.props.onChangePage(id);  
						}.bind(this, data[i].id)}>{data[i].title}
					</a>
				</li>

	(7) 상위컴포넌트( App.js )에서 파라미터 받기 
		<NavC 
          data={this.state.navc}
          onChangePage={function(id){
            this.setState(
              {mode: "read", selected_navc_id: Number(id)}
            );
          }.bind(this)}/>
		
			
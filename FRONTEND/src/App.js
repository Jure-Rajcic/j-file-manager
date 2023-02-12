import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import UploadComponent from './components/UploadComponent';
import DownloadComponent from './components/DownloadComponent';


/**
 * The main component of the application which displays the header, main content, and footer.
 * 
 * @author Jure Rajcic
 */

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact render={() => (
              <div style={{
                height: '100vh',
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
              }}>
                <UploadComponent />
                <DownloadComponent />
              </div>
            )} />
          </Switch>
        </div>
        <FooterComponent />
      </Router>
    </div>

  );
}

export default App;

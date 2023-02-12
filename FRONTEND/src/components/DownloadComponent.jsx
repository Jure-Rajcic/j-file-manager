import React, { Component } from 'react';
import jFileService from '../services/JFileService';
import icon from './resources/download.png';

/**
 * DownloadComponent is a React component that renders a button with a download icon.
 * When the button is clicked, the `downloadFiles` method from `jFileService` is called.
 */
class DownloadComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  /**
   * Renders a button with a download icon.
   */
  render() {
    return (
      <div>
        <img
          src={icon}
          alt="Download Icon"
          width="100"
          height="100"
          onClick={jFileService.downloadFiles}
        />
      </div>
    );
  }
}

export default DownloadComponent;

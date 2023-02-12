import React, { Component } from 'react';
import jFileService from '../services/JFileService';
import icon from './resources/upload.png';

/**
 * UploadComponent is a React component for uploading files.
 * It creates a UI for selecting files and then sending those files to the server for uploading.
 */
class UploadComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            /**
             * selectedFiles is an array of file objects that are selected for uploading.
             */
            selectedFiles: [],
        };
    }

    /**
     * handleFileSelect sets the state of selectedFiles to the files selected by the user.
     * @param {Event} event - The onChange event from the file input element.
     */
    handleFileSelect = async (event) => {
        this.setState({ selectedFiles: event.target.files });
        this.handleUpload();
    };

    /**
     * handleUpload creates a formData object, appends all the selected files to it, 
     * and then sends this formData object to the server using the jFileService.
     */
    handleUpload = async () => {
        const formData = new FormData();
        for (let i = 0; i < this.state.selectedFiles.length; i++) {
            formData.append('file', this.state.selectedFiles[i]);
        }
        jFileService.uploadFiles(formData);
    };

    /**
     * uploadFile creates a file input element, sets its properties and adds an onChange event listener to it.
     * @param {Event} e - The onClick event from the upload image.
     */
    uploadFile = (e) => {
        e.preventDefault();
        let input = document.createElement('input');
        input.type = 'file';
        input.multiple = true;
        input.onchange = this.handleFileSelect;
        input.click();
    };

    render() {
        return (
            <div >
                <img src={icon} alt="Upload Icon" width="100" height="100" onClick={this.uploadFile}></img>
            </div>
        );
    }
}

export default UploadComponent;

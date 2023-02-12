import React, { Component } from 'react'

/**
 * FooterComponent is a stateless component that displays the footer
 * of the JFile platform.
 */
class FooterComponent extends Component {
    /**
     * Constructor to initialize the component state
     * @param {Object} props - The properties passed to the component
     */
    constructor(props) {
        super(props)

        this.state = {}
    }

    /**
     * Renders the FooterComponent component.
     */
    render() {
        return (
            <div>
                <footer className="footer">
                    <span className="text-muted">All Rights Reserved 2023 @JureRajcic</span>
                </footer>
            </div>
        )
    }
}

export default FooterComponent

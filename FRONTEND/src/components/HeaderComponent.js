import React, { Component } from 'react'

/**
 * HeaderComponent is a component for displaying the header of the application
 */
class HeaderComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }

    /**
     * render method for rendering the component
     * 
     * @returns JSX component for the header of the application
     */
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a href="https://javaguides.net" className="navbar-brand">JFile platform</a></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent

import React from 'react'
import { useRef } from 'react'
import generatePDF from 'react-to-pdf'

export default function SavePDF() {
    const getTargetElement = () => document.getElementById('pdf');


    return (
        <button onClick={() => generatePDF(getTargetElement, {filename: 'campground.pdf'})}>Save as PDF</button>
    )
}

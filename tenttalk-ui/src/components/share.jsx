import React from 'react'
import {
    EmailShareButton,
    FacebookShareButton,
    WhatsappShareButton,
  } from "react-share";

  import {
    EmailIcon,
    FacebookIcon,
    WhatsappIcon,
  } from "react-share";

  export default function Share() {
    const currentPageUrl = window.location.href;
    const shareText = 'Check out this Campground!'; 

    return (
        <div className="share-this-page">

            <div style={{ display: 'flex', gap: '10px' }}>
                <FacebookShareButton
                    url={currentPageUrl}
                    quote={shareText}
                >
                    <FacebookIcon size={32} round />
                </FacebookShareButton>

                <EmailShareButton
                    url={currentPageUrl}
                    subject={shareText}
                    body={`Check out this page: ${currentPageUrl}`}
                >
                    <EmailIcon size={32} round />
                </EmailShareButton>

                <WhatsappShareButton
                    url={currentPageUrl}
                    title={shareText}
                >
                    <WhatsappIcon size={32} round />
                </WhatsappShareButton>
            </div>
        </div>
    );



};
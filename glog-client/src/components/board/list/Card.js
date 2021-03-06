import { Link } from 'react-router-dom';
import styled from 'styled-components';
import Images from '../../layout/Images';
import Tag from '../element/Tag';


function Card({ path, open, url, preview }) {
    return (
        <>
            <StyledCard>
                <Link to={url ? url : ''}>
                    <Images src={path} width={768} height={452} />
                    <h2>glog</h2>
                    <p className="preview">
                        {preview}
                    </p>
                    <StyledTagWrap>
                        <Tag children="glog" />
                        <Tag children="test" />
                    </StyledTagWrap>
                    <StyledSubInfo>
                        <span>2021년 11월 16일</span>
                        <div className="separator">·</div>
                        <span>0개의 댓글</span>
                        <div className="separator">·</div>
                        <span className={open ? 'open' : 'secret'}>
                            {open ? '공개' : '비공개'}
                        </span>
                    </StyledSubInfo>
                </Link>
            </StyledCard>
        </>
    );
}

const StyledCard = styled.a`
    display: block;
    margin: 0 auto;
    padding-bottom: 4rem;
    width: 768px;
    cursor: pointer;
    color: #383838;
    text-align: left;
    h2 {
        font-size: 1.5rem;
        font-weight: 600;
        padding: 15px 0;
    }
    p {
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 3;
        -webkit-box-orient: vertical;
        word-wrap: break-word;
        line-height: 1.2em;
        max-height: 3.6em;
        margin-bottom: 20px;
    }
    
`;
const StyledTagWrap = styled.div`
    display: flex;
    align-items: center;
    margin-left: -10px;
`;
const StyledSubInfo = styled.div`
    display: flex;
    align-items: center;
    margin-top: 0.8rem;
    color: #6a6d6e;
    .separator {
        margin: 0 0.5rem;
    }
    .open {
        border-radius : 0.5rem;
        padding: 3px 10px;
        border: 2px solid #a680d2;
        color: #a680d2;
        font-weight: 700;
    }
    .secret {
        border-radius : 0.5rem;
        padding: 5px 10px;
        background-color: #383838;
        color: #fff;
        font-weight: 700;
    }
`;

export default Card;
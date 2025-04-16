import { fetchCommentById } from "@/lib/comments.API";
import { use, useState, useEffect } from "react";
import { ThumbsDown, ThumbsUp } from "lucide-react";
import style from "./Comment.module.css"



async function getCommentFromId(id) {
    return await fetchCommentById(id)
}

export default function Comment({ id }) {
    const [comment, setComment] = useState(null)

    useEffect(() => {
        const fetchComment = async () => {
            const data = await getCommentFromId(id);
            setComment(data);
        };

        fetchComment();
    }, [id]);

    return (
        <>  <div>
            {comment ? <>
                <div className={style.comment}>
                    <div className={style.profilImg}>
                        <p>{comment.account.username.charAt(0).toUpperCase()}</p>
                    </div>
                    <div>
                        <p className={style.content} >{comment.text}</p>
                        <div className={style.buttonRight}>
                           
                            <div className={style.likesButtons}>
                                <button className={style.likeButton}><ThumbsUp /><p>{comment.likes}</p></button>
                                <button className={style.likeButton} ><ThumbsDown /></button>
                            </div>
                        </div>
                    </div>
                </div>
            </>
                :
                <p>loading...</p>}
        </div>
        </>
    )
}
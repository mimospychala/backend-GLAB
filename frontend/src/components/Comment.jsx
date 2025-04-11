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
    console.log(comment)
    return (
        <>  <div>
            {comment ? <>
                <div>
                    <p>{comment.text}</p>
                </div>
                <div className={style.likesButton}>
                    <ThumbsUp /><p>{comment.likes}</p>
                    <ThumbsDown /><p>{comment.dislikes}</p>
                </div>
            </> : <p>loading...</p>}
        </div>
        </>
    )
}
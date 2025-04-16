import { useState, useEffect } from "react";
import Comment from "./comment";
import { fetchProductById } from "@/lib/products.API";
import styles from "./Comments.module.css"
import CommentBar from "./CommentBar";
import { X } from "lucide-react";
import Button from "./Button";
import { createComment } from "@/lib/comments.API";




async function getProductById(id) {
    return await fetchProductById(id)
}


export default function Comments({ id, func }) {
    const [product, setProduct] = useState(null)
    const [comment, setComment] = useState('');

    const fetchComment = async () => {
        const data = await getProductById(id);
        setProduct(data);
    };

    useEffect(() => {
        fetchComment();
    }, [id]);
    
    async function postComment(comment, id) {
        if(!comment){return}
        const data = {
            text : `${comment}`,
            productId :  id,
            comboId :  1
        }
    
        await createComment(data)
        await fetchComment()
    }
    

    return (<>
        {product ?
            <>
                <div>
                    <div className={styles.comentareHeader}>
                        <div />
                        <h3 className={styles.comentarTitle}>Kommentare:</h3>
                        <button onClick={func} className={styles.xButton}>
                            <X />
                        </button>
                    </div>
                    <div className={styles.commentsFeld}>
                        {product.linkedCommmentIds.slice().reverse().map((commentId) => <Comment id={commentId} />)}
                    </div>
                    <div>
                        <CommentBar func={setComment} />
                    </div>
                    <div className={styles.sendButton}>
                        <div />
                        <Button onClick={(e) => postComment(comment, id)} >Send</Button>
                    </div>
                </div>
            </>
            : <p>loading...</p>}
    </>)
}
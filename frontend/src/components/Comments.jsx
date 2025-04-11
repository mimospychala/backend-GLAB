import { useState, useEffect } from "react";
import Comment from "./comment";
import { fetchProductById } from "@/lib/products.API";
import styles from "./Comments.module.css"
import CommentBar from "./CommentBar";
import { X } from "lucide-react";


async function getProductById(id) {
    return await fetchProductById(id)
}

export default function Comments({ id, func }) {
    const [product, setProduct] = useState(null)
    useEffect(() => {
        const fetchComment = async () => {
            const data = await getProductById(id);
            setProduct(data);
        };

        fetchComment();
    }, [id]);

    return (<>
        {product ?
            <>
                <div className={styles.comentareHeader}>
                    <div className={styles.filler}></div>
                    <h3 className={styles.comentarTitle}>Kommentare:</h3>
                    <button onClick={func} className={styles.xButton}>
                        <X />
                    </button>
                </div>
                <div className={styles.commentsFeld}>
                    {product.linkedCommmentIds.map((commentId) => <Comment id={commentId} />)}
                </div>
                <div>
                    <CommentBar />
                </div>
            </>
            : <p>loading...</p>}
    </>)
}
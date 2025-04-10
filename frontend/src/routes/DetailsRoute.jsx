import CommentButton from "@/components/CommentButton";
import NumNumRating from "@/components/numNumRating";
import ShareButton from "@/components/ShareButton";


import "./DetailsRoute.module.css"
import styles from "./DetailsRoute.module.css"
import Button from "@/components/Button";
import LikeButton from "@/components/LikeButton";

export default function DetailRoute({ product }) {
    return (
        <>
            <div className={styles.container}>
                <img src={product.img} alt="Produkt image" />
                <div className={styles.itemContainer}>
                    <div>
                        <h2>{product.name}</h2>
                        
                    </div>
                    <div className={styles.ratingMarke}>
                        <NumNumRating rating={product.numNumRating}/>
                        <div className={styles.spacer}></div>
                        <div>
                            <p>Marke:</p>
                            <h3>{product.marke}</h3>
                        </div>
                    </div>
                    <div className={styles.comentShare}>
                        <LikeButton/>
                        <CommentButton/>
                        <ShareButton/>
                    </div>
                    <Button className={styles.toPayOutButton}>Zur Kasse</Button>
                </div>
            </div>
        </>
    )
}
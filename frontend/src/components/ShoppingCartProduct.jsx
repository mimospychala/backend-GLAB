import { Link } from "react-router"

import styles from "./Chronicle.module.css"

export default function Chronicle({ title, text, url }) {
  return (
    <article className={styles.card}>
      <h3 className={styles.title}>{title}</h3>
      <p className={styles.text}>{text}</p>
      <Link to={url} className={styles.link}>
        Details anzeigen
      </Link>
    </article>
  )
}

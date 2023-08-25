import React, { useState } from "react";
import "../styles/Pagination.css";
import {PropsPagesDefault} from "../BaseTs"

function Paging({ setCurPage, curPage, totalPages }:PropsPagesDefault) {
  const [page, setPage] = useState<number>(curPage);

  const next = () => {
    setPage(page + 1);
    setCurPage(page + 1);
  };

  const back = () => {
    setPage(page - 1);
    setCurPage(page - 1);
  };

  return (
    <div className="pagination">
      <div className="button">
        <button onClick={back} disabled={page <= 1}>
          back
        </button>
      </div>
      <p>{page}</p>
      <div className="button">
        <button onClick={next} disabled={page >= totalPages}>
          next
        </button>
      </div>
    </div>
  );
}
export default Paging;
